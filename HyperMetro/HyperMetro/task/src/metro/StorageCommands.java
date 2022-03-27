package metro;

import static java.lang.String.join;

public class StorageCommands {
    private StorageCommands() {
    }

    static StorageCommand add(final String lineName, final String stationName) {
        return new AddCommand(lineName, stationName);
    }

    public static StorageCommand remove(final String lineName, final String stationName) {
        return storage -> storage.remove(lineName, stationName);
    }

    public static StorageCommand output(final String lineName) {
        return storage -> System.out.println(join(" -", storage.stationsByLine(lineName)));
    }
}
