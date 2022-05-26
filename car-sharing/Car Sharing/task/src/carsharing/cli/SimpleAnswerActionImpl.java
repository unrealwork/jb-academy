package carsharing.cli;

import java.util.Scanner;
import java.util.function.Function;

class SimpleAnswerActionImpl<T> extends BaseAnswerAction<T> {
    private final Function<Scanner, T> reader;

    private SimpleAnswerActionImpl(Scanner scanner, Function<Scanner, T> reader) {
        super(scanner);
        this.reader = reader;
    }

    static <T> SimpleAnswerActionImpl<T> create(Scanner scanner, Function<Scanner, T> reader) {
        return new SimpleAnswerActionImpl<T>(scanner, reader);
    }

    @Override
    T read() {
        return reader.apply(scanner());
    }
}
