package metro.commands;

public interface StorageCommandFactory {
    StorageCommand get();

    static StorageCommand fromCommand(final String cmd) {
        return new StorageCommandFactoryImpl(ConsoleCommand.parse(cmd))
                .get();
    }
}
