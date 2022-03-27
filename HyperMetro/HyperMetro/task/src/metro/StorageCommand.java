package metro;

@FunctionalInterface
public interface StorageCommand {

    void run(SubwayStorage storage);
}
