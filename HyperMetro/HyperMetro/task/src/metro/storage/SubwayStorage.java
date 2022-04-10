package metro.storage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import metro.ds.WeightedGraph;
import metro.model.Station;
import metro.model.Transfer;
import metro.route.Route;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface SubwayStorage {
    List<Station> stationsByLine(final String lineName);

    void append(String lineName, String stationName);

    void addHead(String lineName, String stationName);

    void remove(String lineName, String stationName);

    static SubwayStorage fromJsonFile(Path pathToFile) throws IOException {
        Gson gson = new Gson();
        TypeToken<Map<String, List<Station>>> mapTypeToken = new TypeToken<Map<String, List<Station>>>() {
        };
        try (final Reader reader = Files.newBufferedReader(pathToFile)) {
            Map<String, List<Station>> storage = gson.fromJson(reader, mapTypeToken.getType());
            return new InMemorySubwayStorage(storage.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, e -> mapToDeque(e.getValue()))));
        }
    }

    static Deque<Station> mapToDeque(final List<Station> list) {
        return new ArrayDeque<>(list);
    }

    void connect(Transfer station1, Transfer station2);

    Route route(Transfer transfer1, Transfer transfer2);

    WeightedGraph<Transfer> asWeightedGraph();

    WeightedGraph<Transfer> asTimelessGraph();

    Station findStation(String lineName, String stationName);
}
