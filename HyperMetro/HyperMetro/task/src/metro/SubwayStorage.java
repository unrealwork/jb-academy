package metro;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;

public interface SubwayStorage {
    List<String> stationsByLine(final String lineName);

    void append(String lineName, String stationName);

    void addHead(String lineName, String stationName);

    void remove(String lineName, String stationName);

    static SubwayStorage fromJsonFile(Path pathToFile) throws IOException {
        Gson gson = new Gson();
        TypeToken<Map<String, Map<String, String>>> mapTypeToken = new TypeToken<>() {
        };
        try (final Reader reader = Files.newBufferedReader(pathToFile)) {
            Map<String, Map<String, String>> storage = gson.fromJson(reader, mapTypeToken.getType());
            return new InMemorySubwayStorage(storage.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, e -> mapToDeque(e.getValue()))));
        }
    }

    private static Deque<String> mapToDeque(final Map<String, String> map) {
        return map.entrySet()
                .stream()
                .sorted(comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }
}
