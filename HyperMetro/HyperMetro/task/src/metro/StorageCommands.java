package metro;

import java.util.List;
import java.util.stream.Collectors;

public class StorageCommands {

    private StorageCommands() {
    }

    static StorageCommand append(final String lineName, final String stationName) {
        return new AppendCommand(lineName, stationName);
    }

    static StorageCommand addHead(final String lineName, final String stationName) {
        return storage -> storage.addHead(lineName, stationName);
    }
    public static StorageCommand remove(final String lineName, final String stationName) {
        return storage -> storage.remove(lineName, stationName);
    }

    public static StorageCommand output(final String lineName) {
        return storage -> Printer.stations(storage.stationsByLine(lineName)).print();
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
