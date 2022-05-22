package animals.cli;

public abstract class CliMessage implements Message {

    @Override
    public Void execute() {
        print();
        return null;
    }

    @Override
    @SuppressWarnings("squid:S106")
    public void print() {
        System.out.println(content());
    }
}
