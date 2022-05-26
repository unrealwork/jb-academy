package carsharing.cli;

import java.util.Scanner;
import java.util.function.Function;

class CliActionFactoryImpl implements ActionFactory {

    private final Scanner scanner = new Scanner(System.in);


    @Override
    public Action<Void> message(String message) {
        return new CliMessageAction(System.out, message);
    }

    @Override
    public <T> Action<T> answer(Function<Scanner, T> reader) {
        return SimpleAnswerActionImpl.create(scanner, reader);
    }

    @Override
    public Scanner scanner() {
        return scanner;
    }

    @Override
    public void close() {
        scanner.close();
    }
}
