package metro;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class InMemorySubwayStorage implements SubwayStorage {
    private final Map<String, Deque<String>> storage;

    public InMemorySubwayStorage(Map<String, Deque<String>> storage) {
        this.storage = storage;
    }

    @Override
    public List<String> stationsByLine(String lineName) {
        return new ArrayList<>(storage.get(lineName));
    }

    @Override
    public void append(String lineName, String stationName) {
        storage.computeIfAbsent(lineName, n -> new ConcurrentLinkedDeque<>())
                .add(stationName);
    }

    @Override
    public void addHead(String lineName, String stationName) {
        storage.computeIfAbsent(lineName, n -> new LinkedList<>())
                .addFirst(stationName);
    }

    @Override
    public void remove(String lineName, String stationName) {
        Deque<String> stations = storage.get(lineName);
        if (stations != null) {
            stations.remove(stationName);
        }
    }
}
