package carsharing.cli;

import java.util.Scanner;

abstract class BaseAnswerAction<T> implements Action<T> {
    private final Scanner scanner;

    BaseAnswerAction(Scanner scanner) {
        this.scanner = scanner;
    }


    abstract T read();

    @Override
    public T execute() {
        return read();
    }
    
    protected Scanner scanner() {
        return scanner;
    }
}
