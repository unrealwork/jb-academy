package animals.cli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

class RandomGenerator<T> implements Supplier<T> {
    private final List<T> messages;

    public RandomGenerator(Set<T> messages) {
        this.messages = new ArrayList<>(messages);
    }


    @Override
    public T get() {
        int index = ThreadLocalRandom.current()
                .nextInt(messages.size());
        return messages.get(index);
    }

    static <T> Supplier<T> random(Set<T> options) {
        return new RandomGenerator<>(options);
    }

    static <T> Supplier<T> random(T... options) {
        return new RandomGenerator<>(new HashSet<>(Arrays.asList(options)));
    }


}
