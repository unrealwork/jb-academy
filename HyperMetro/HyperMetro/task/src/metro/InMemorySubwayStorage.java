package metro;

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
