package metro.storage;

import metro.ds.Graph;
import metro.ds.WeightedGraph;
import metro.model.Station;
import metro.model.StationVertex;
import metro.model.Transfer;
import metro.route.Route;
import metro.route.RouteFinder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedDeque;

public class InMemorySubwayStorage implements SubwayStorage {
    public static final int DEFAULT_TRANSITION_TIME = 5;
    private final Map<String, Deque<Station>> storage;

    public InMemorySubwayStorage(Map<String, Deque<Station>> storage) {
        this.storage = storage;
    }

    @Override
    public List<Station> stationsByLine(String lineName) {
        return new ArrayList<>(storage.get(lineName));
    }

    @Override
    public void append(String lineName, String stationName) {
        storage.computeIfAbsent(lineName, n -> new ConcurrentLinkedDeque<>())
                .add(new Station(stationName));
    }

    @Override
    public void addHead(String lineName, String stationName) {
        storage.computeIfAbsent(lineName, n -> new LinkedList<>())
                .addFirst(new Station(stationName));
    }

    @Override
    public void remove(String lineName, String stationName) {
        Deque<Station> stations = storage.get(lineName);
        if (stations != null) {
            stations.remove(findByName(stations, stationName));
        }
    }

    @Override
    public void connect(Transfer station1, Transfer station2) {
        findStation(station1.getLine(), station1.getStation())
                .addTransfer(station2);
        findStation(station2.getLine(), station2.getStation())
                .addTransfer(station1);
    }

    @Override
    public Route route(Transfer transfer1, Transfer transfer2) {
        final RouteFinder finder = RouteFinder.shortest(this);
        return finder.find(transfer1, transfer2);
    }

    @Override
    public WeightedGraph<Transfer> asWeightedGraph() {
        return asWeightedGraph(DEFAULT_TRANSITION_TIME, true);
    }

    @Override
    public WeightedGraph<Transfer> asTimelessGraph() {
        return asWeightedGraph(0, false);
    }

    public WeightedGraph<Transfer> asWeightedGraph(int transitionTime, boolean useTransactionTime) {
        final WeightedGraph<Transfer> g = Graph.directed();
        for (Map.Entry<String, Deque<Station>> e : storage.entrySet()) {
            final String line = e.getKey();
            Deque<Station> lineStations = e.getValue();
            for (Station station : lineStations) {
                int time = station.getTime();
                Transfer u = new Transfer(line, station.getName());
                if (time > 0) {
                    for (String nextStation : station.getNext()) {
                        Transfer v = new Transfer(line, nextStation);
                        g.addEdge(v, u, useTransactionTime ? time : 1);
                        g.addEdge(u, v, useTransactionTime ? time : 1);
                    }
                }
                List<Transfer> transfer = station.getTransfer();
                if (transfer != null) {
                    for (Transfer transition : transfer) {
                        g.addEdge(u, transition, transitionTime);
                        g.addEdge(transition, u, transitionTime);
                    }
                }
            }
        }
        return g;
    }

    @Override
    public Station findStation(final String lineName, final String stationName) {
        Deque<Station> stations = storage.get(lineName);
        return findByName(stations, stationName);
    }

    private Station findByName(Deque<Station> stations, String stationName) {
        return stations.stream()
                .filter(st -> Objects.equals(st.getName(), stationName))
                .findFirst()
                .orElse(null);
    }

    private StationVertex computeStationVertex(Transfer tr) {
        StationVertex v = StationVertex.fromStation(tr.getLine(), findStation(tr.getLine(), tr.getStation()));
        return v;
    }
}
