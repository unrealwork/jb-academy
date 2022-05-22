package animals.cli;

import java.util.function.Supplier;

public class RandomMessage implements Message {
    private final Supplier<String> messageSupplier;

    public RandomMessage(String... messages) {
        messageSupplier = RandomGenerator.random(messages);
    }

    @Override
    public Void execute() {
        print();
        return null;
    }

    @Override
    public String content() {
        return messageSupplier.get();
    }

    @Override
    @SuppressWarnings("squid:S106")
    public void print() {
        System.out.println(content());
    }
}
