package animals;

import java.util.Set;

import static animals.MessageKeys.*;

class DefaultMessageStorage extends MessageStorageDecorator {


    public DefaultMessageStorage() {
        super(storage());
    }

    private static MessageStorage storage() {
        final var storage =
                MapBuilder.<String, Set<String>>immutable()
                        .put(GREETING_MORNING, Set.of(
                                "Good morning!")
                        ).put(GREETING_AFTERNOON, Set.of(
                                "Good afternoon!")
                        ).put(GREETING_EVENING, Set.of(
                                "Good evening!"
                        )).put(BYE, Set.of(
                                "Have a nice day!",
                                "See you soon!",
                                "Bye!"
                        )).put(FACT_TEMPLATE, Set.of(
                                "Specify a fact that distinguishes {} from {}.\n" +
                                        "The sentence should be of the format: 'It can/has/is ...'."
                        )).put(FACT_CONFIRM, Set.of(
                                "The examples of a statement:\n" +
                                        " - It can fly\n" +
                                        " - It has horn\n" +
                                        " - It is a mammal"
                        )).build();
        return new InMemoryMessageStorage(storage);
    }
}
