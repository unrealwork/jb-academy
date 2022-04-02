package metro.commands;

import metro.model.Transfer;

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
            case "append":
                return StorageCommands.append(args.get(0), args.get(1));
            case "add-head":
                return StorageCommands.addHead(args.get(0), args.get(1));
            case "output":
                return StorageCommands.output(args.get(0));
            case "remove":
                return StorageCommands.remove(args.get(0), args.get(1));
            case "connect":
                final Transfer st1 = new Transfer(args.get(0), args.get(1));
                final Transfer st2 = new Transfer(args.get(2), args.get(3));
                return new ConnectCommand(st1, st2);
            case "route":
                final Transfer t1 = new Transfer(args.get(0), args.get(1));
                final Transfer t2 = new Transfer(args.get(2), args.get(3));
                return new RouteCommand(t1, t2);
            case "exit":
                return StorageCommands.exit();
            default:
                throw new IllegalStateException("Unsupported command : " + type);
        }
    }
}
