package metro;

import java.util.List;

public class StorageCommandFactoryImpl implements StorageCommandFactory {
    private final ConsoleCommand command;

    public StorageCommandFactoryImpl(ConsoleCommand command) {
        this.command = command;
    }

    @Override
    public StorageCommand get() {
        final String type = command.getType();
        final List<String> args = command.getArgs();
        switch (type) {
            case "add":
                return new AppendCommand(args.get(0), args.get(1));
            case "output":
                return StorageCommands.output(args.get(0));
            case "remove":
                return StorageCommands.remove(args.get(0), args.get(1));
            case "exit":
                return StorageCommands.exit();
            default:
                throw new IllegalStateException("Unsupported command : " + type);
        }
    }
}
