package metro;

import java.util.List;
import java.util.stream.Collectors;

public class StorageCommands {

    public static final String DEPOT_STATION_NAME = "depot";

    private StorageCommands() {
    }

    static StorageCommand add(final String lineName, final String stationName) {
        return new AppendCommand(lineName, stationName);
    }

    public static StorageCommand remove(final String lineName, final String stationName) {
        return storage -> storage.remove(lineName, stationName);
    }

    public static StorageCommand output(final String lineName) {
        return storage -> System.out.println(format(lineName, storage));
    }

    private static String format(String lineName, SubwayStorage storage) {
        List<String> elements = storage.stationsByLine(lineName);
        return elements.stream().collect(Collectors.joining(
                " - ", "depot - ", " - depot"
        ));
    }

    public static StorageCommand exit() {
        return storage -> System.exit(0);
    }
}
