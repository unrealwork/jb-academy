package metro.storage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import metro.model.Station;
import metro.model.Transfer;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Comparator;
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
        TypeToken<Map<String, Map<String, Station>>> mapTypeToken = new TypeToken<Map<String, Map<String, Station>>>() {
        };
        try (final Reader reader = Files.newBufferedReader(pathToFile)) {
            Map<String, Map<String, Station>> storage = gson.fromJson(reader, mapTypeToken.getType());
            return new InMemorySubwayStorage(storage.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, e -> mapToDeque(e.getValue()))));
        }
    }

    static Deque<Station> mapToDeque(final Map<String, Station> map) {
        return map.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(e -> Integer.parseInt(e.getKey())))
                .map(Map.Entry::getValue)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    void connect(Transfer station1, Transfer station2);
}
