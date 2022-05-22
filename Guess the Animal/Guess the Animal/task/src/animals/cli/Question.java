package animals.cli;

import java.util.Scanner;

public abstract class Question<T> implements Action<T> {

    private final Scanner scanner;

    protected Question(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract T read(Scanner sc);

    public abstract Message question();

    public Scanner scanner() {
        return scanner;
    }

    @Override
    public T execute() {
        question().execute();
        return read(scanner());
    }
}
