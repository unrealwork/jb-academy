package animals.cli;

public abstract class CliMessage implements Message {

    @Override
    public Void execute() {
        print();
        return null;
    }

    @Override
    public abstract String content();

    @Override
    public void print() {
        System.out.println(content());
    }
}
