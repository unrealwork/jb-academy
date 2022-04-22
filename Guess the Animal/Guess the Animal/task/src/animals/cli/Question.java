package animals.cli;

import java.util.Scanner;

public abstract class Question<T> implements Action<T> {

    public abstract T read(Scanner sc);

    public abstract Message question();

    public abstract Scanner scanner();

    @Override
    public T execute() {
        question().execute();
        return read(scanner());
    }
}
