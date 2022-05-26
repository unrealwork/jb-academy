package carsharing.cli;

import java.io.PrintStream;

public abstract class MessageAction implements Action<Void> {
    private final PrintStream writer;

    protected MessageAction(PrintStream writer) {
        this.writer = writer;
    }

    @Override
    public Void execute() {
        writer.println(message());
        return null;
    }

    abstract String message();
}
