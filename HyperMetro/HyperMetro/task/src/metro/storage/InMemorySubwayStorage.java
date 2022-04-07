package metro.storage;

import metro.ds.Graph;
import metro.model.Station;
import metro.model.StationVertex;
import metro.model.Transfer;
import metro.route.Route;
import metro.route.RouteFinder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedDeque;

public class InMemorySubwayStorage implements SubwayStorage {
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

    private StationVertex vertexFromTransfer(Transfer transfer) {
        Station station = findStation(transfer.getLine(), transfer.getStation());
        return StationVertex.fromStation(transfer.getLine(), station);
    }

    @Override
    public Route route(Transfer transfer1, Transfer transfer2) {
        final RouteFinder finder = RouteFinder.shortest(this);
        return finder.find(transfer1, transfer2);
    }

    @Override
    public Graph<StationVertex> asGraph() {
        final Graph<StationVertex> g = Graph.directed();
        Map<Transfer, StationVertex> stationVertexDict = new HashMap<>();
        for (Map.Entry<String, Deque<Station>> e : storage.entrySet()) {
            final String line = e.getKey();
            Deque<Station> lineStations = e.getValue();
            StationVertex prev = null;
            for (Station station : lineStations) {
                StationVertex u = stationVertexDict.computeIfAbsent(new Transfer(line, station.getName()), this::computeStationVertex);
                if (prev != null) {
                    g.addEdge(prev, u);
                    g.addEdge(u, prev);
                }
                prev = u;
                g.addNode(u);
                List<Transfer> transfer = station.getTransfer();
                if (transfer != null) {
                    transfer.forEach(t -> {
                        StationVertex v = stationVertexDict.computeIfAbsent(t, this::computeStationVertex);
                        g.addEdge(u, v);
                        g.addEdge(v, u);
                    });
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
        return StationVertex.fromStation(tr.getLine(), findStation(tr.getLine(), tr.getStation()));
    }
}
