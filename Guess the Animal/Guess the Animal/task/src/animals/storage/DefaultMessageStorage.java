package animals.storage;

import animals.util.MapBuilder;

import java.util.Set;

import static animals.storage.MessageKeys.*;

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
                        )).put(NOT_SURE, Set.of(
                                "I'm not sure I caught you: was it yes or no?",
                                "Funny, I still don't understand, is it yes or no?",
                                "Oh, it's too complicated for me: just tell me yes or no.",
                                "Could you please simply say yes or no?",
                                "Oh, no, don't try to confuse me: say yes or no."
                        ))
                        .put(YES, Set.of(
                                "y", "yes", "yeah", "yep", "sure", "right", "affirmative", "correct", "indeed", "you bet", "exactly", "you said it"
                        ))
                        .put(NO, Set.of(
                                "n", "no", "no way", "nah", "nope", "negative", "I don't think so", "yeah no"
                        )).put(FACT_CORRECT_QUESTION, Set.of(
                                "Is the statement correct for {}?"
                        ))
                        .put(FACT_DESCRIPTION, Set.of(
                                "I have learned the following facts about animals:\n" +
                                        "- {}.\n" +
                                        "- {}.\n" +
                                        "I can distinguish these animals by asking the question:\n" +
                                        "- {}"
                        ))
                        .put(BASE_ANIMAL_REQUEST, Set.of(
                                "I want to learn about animals.\n" +
                                        "Which animal do you like most?"
                        ))
                        .put(GAME_INTRO, Set.of(
                                "Wonderful! I've learned so much about animals!\n" +
                                        "Let's play a game!\n" +
                                        "You think of an animal, and I guess it.\n" +
                                        "Press enter when you're ready."
                        ))
                        .put(NEW_ANIMAL, Set.of(
                                "I give up. What animal do you have in mind?"
                        ))
                        .put(NEW_KNOWLEDGE, Set.of(
                                "Nice! I've learned so much about animals!"
                        ))
                        .put(PLAY_AGAIN, Set.of(
                                "Would you like to play again?"
                        ))
                        .put(MENU_GAME, Set.of(
                                "Play the guessing game"
                        ))
                        .put(MENU_INTRO, Set.of(
                                "Welcome to the animal expert system!\n" +
                                        "\n" +
                                        "What do you want to do:\n" +
                                        "\n"
                        ))
                        .put(MENU_LIST, Set.of(
                                "List of all animals"
                        ))
                        .put(MENU_SEARCH, Set.of(
                               "Search for an animal" 
                        ))
                        .put(MENU_STAT, Set.of(
                                "Calculate statistics"
                        ))
                        .put(MENU_PRINT_TREE, Set.of(
                            "Print the Knowledge Tree"      
                        ))
                        .put(MENU_EXIT, Set.of(
                                "Exit"
                        ))
                        .put(STAT_TITLE, Set.of(
                                "The Knowledge Tree stats\n" +
                                        "\n"
                        ))
                        .put(STAT_ROOT_NODE, Set.of(
                                "root node"
                        ))
                        .put(STAT_TOTAL_NODES, Set.of(
                                "total number of nodes"
                        ))
                        .put(STAT_TOTAL_ANIMALS, Set.of(
                                "total number of animals"
                        ))
                        .put(STAT_TOTAL_STATEMENTS, Set.of(
                                "total number of statements"
                        ))
                        .put(STAT_HEIGHT, Set.of(
                                "height of the tree"
                        ))
                        .put(STAT_MIN_DEPTH, Set.of(
                                "minimum animal's depth"
                        ))
                        .put(STAT_AVG_DEPTH, Set.of(
                                "average animal's depth"
                        ))
                        .put(LIST_TITLE, Set.of(
                                "Here are the animals I know:"
                        ))
                        .build();
        return new InMemoryMessageStorage(storage);
    }
}
