package animals.cli;

public class SimpleMessage extends CliMessage {
    private final String msg;

    public SimpleMessage(String msg) {
        this.msg = msg;
    }

    @Override
    public String content() {
        return msg;
    }
}
