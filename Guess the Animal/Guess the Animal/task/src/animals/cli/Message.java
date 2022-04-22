package animals.cli;

public interface Message extends Action<Void> {
    String content();
    void print();
}
