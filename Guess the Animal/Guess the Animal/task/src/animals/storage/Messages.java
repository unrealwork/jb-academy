package animals.storage;

import java.util.ListResourceBundle;
import java.util.Locale;

import static animals.storage.MessageKeys.*;

public class Messages extends ListResourceBundle {
    @Override
    public Locale getLocale() {
        return Locale.US;
    }

    @Override
    public String getBaseBundleName() {
        return "Messages";
    }

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {GREETING_MORNING, "Good morning!"},
                {GREETING_MORNING, "Good afternoon!"},
                {GREETING_EVENING, "Good evening!"},
                {BYE, new String[] {
                        "Have a nice day!",
                        "See you soon!",
                        "Bye!"}},
                {FACT_TEMPLATE,
                        "Specify a fact that distinguishes {0} from {1}.\n" +
                                "The sentence should be of the format: 'It can/has/is ...'."}, {FACT_CONFIRM,
                "The examples of a statement:\n" +
                        " - It can fly\n" +
                        " - It has horn\n" +
                        " - It is a mammal"},
                {NOT_SURE, new String[] {
                        "I'm not sure I caught you: was it yes or no?",
                        "Funny, I still don't understand, is it yes or no?",
                        "Oh, it's too complicated for me: just tell me yes or no.",
                        "Could you please simply say yes or no?",
                        "Oh, no, don't try to confuse me: say yes or no."}
                },
                {YES, new String[] {
                        "y", "yes", "yeah", "yep", "sure", "right", "affirmative", "correct", "indeed", "you bet", "exactly", "you said it"}
                },
                {NO, new String[] {
                        "n", "no", "no way", "nah", "nope", "negative", "I don't think so", "yeah no"}},
                {FACT_CORRECT_QUESTION, "Is the statement correct for {0}?"},
                {FACT_DESCRIPTION, "I have learned the following facts about animals:\n" +
                        "- {0}.\n" +
                        "- {1}.\n" +
                        "I can distinguish these animals by asking the question:\n" +
                        "- {2}"
                },
                {BASE_ANIMAL_REQUEST, "I want to learn about animals.\n" +
                        "Which animal do you like most?"
                },
                {GAME_INTRO, "Wonderful! I've learned so much about animals!\n" +
                        "Let's play a game!\n" +
                        "You think of an animal, and I guess it.\n" +
                        "Press enter when you're ready."
                },
                {NEW_ANIMAL, "I give up. What animal do you have in mind?"},
                {NEW_KNOWLEDGE, "Nice! I've learned so much about animals!"},
                {PLAY_AGAIN, "Would you like to play again?"},
                {MENU_GAME, "Play the guessing game"},
                {MENU_INTRO, "Welcome to the animal expert system!\n" +
                        "\n" +
                        "What do you want to do:\n" +
                        "\n"
                },
                {MENU_LIST, "List of all animals"},
                {MENU_SEARCH, "Search for an animal"},
                {MENU_STAT, "Calculate statistics"},
                {MENU_PRINT_TREE, "Print the Knowledge Tree"},
                {MENU_EXIT, "Exit"},
                {STAT_TITLE, "The Knowledge Tree stats\n" +
                        "\n"
                },
                {STAT_ROOT_NODE, "- root node                    {0}"},
                {STAT_TOTAL_NODES, "- total number of nodes        {0,number,integer}"}, 
                {STAT_TOTAL_ANIMALS, "- total number of animals      {0,number,integer}"}, 
                {STAT_TOTAL_STATEMENTS, "- total number of statements   {0,number,integer}"}, 
                {STAT_HEIGHT, "- height of the tree           {0,number,integer}"}, 
                {STAT_MIN_DEPTH, "- minimum depth                {0,number,integer}"}, 
                {STAT_AVG_DEPTH, "- average depth                {0,number,##0.0}"}, 
                {LIST_TITLE, "Here are the animals I know:"}, 
                {ENTER_ANIMAL, "Enter the animal:"}, 
                {FACTS_ABOUT, "Facts about the {0}:"}, 
                {NO_FACTS, "No facts about the {0}."}
        };
    }
}
