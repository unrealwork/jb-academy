package metro;

public class AppendCommand implements StorageCommand {
    private final String lineName;
    private final String stationName;

    public AppendCommand(String lineName, String stationName) {
        this.lineName = lineName;
        this.stationName = stationName;
    }

    @Override
    public void run(SubwayStorage storage) {
        storage.append(lineName, stationName);
    }
}
