package metro.storage;

import metro.ds.Graph;
import metro.model.Station;
import metro.model.Transfer;

import java.util.ArrayList;
import java.util.Deque;
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

    @Override
    public List<Station> route(Transfer transfer1, Transfer transfer2) {
        final Graph<Transfer> g = asGraph();
        return null;
    }

    private Graph<Transfer> asGraph() {
        final Graph<Transfer> g = Graph.directed();
        for (Map.Entry<String, Deque<Station>> e : storage.entrySet()) {
            final String line = e.getKey();
            for (Station station : e.getValue()) {
                Transfer u = new Transfer(line, station.getName());
                g.addNode(u);
                List<Transfer> transfer = station.getTransfer();
                if (transfer != null) {
                    transfer.forEach(t -> {
                        g.addEdge(u, t);
                        g.addEdge(t, u);
                    });
                }
            }
        }
        return g;
    }
    
    private Station findStation(final String lineName, final String stationName) {
        Deque<Station> stations = storage.get(lineName);
        return findByName(stations, stationName);
    }

    private Station findByName(Deque<Station> stations, String stationName) {
        return stations.stream()
                .filter(st -> Objects.equals(st.getName(), stationName))
                .findFirst()
                .orElse(null);
    }
}
