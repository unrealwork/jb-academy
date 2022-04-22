package animals.cli;

import java.util.function.Supplier;

public class RandomMessage implements Message {
    private final Supplier<String> randomMessage;

    public RandomMessage(String... messages) {
        randomMessage = RandomGenerator.random(messages);
    }

    @Override
    public Void execute() {
        print();
        return null;
    }

    @Override
    public String content() {
        return randomMessage.get();
    }

    @Override
    public void print() {
        System.out.println(content());
    }
}
