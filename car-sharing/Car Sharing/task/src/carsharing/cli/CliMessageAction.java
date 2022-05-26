package carsharing.cli;

import java.io.PrintStream;
import java.io.Writer;

class CliMessageAction extends MessageAction {

    private final String message;

    protected CliMessageAction(PrintStream writer, String message) {
        super(writer);
        this.message = message;
    }

    @Override
    String message() {
        return message;
    }
}
