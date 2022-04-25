package animals.cli;

import java.util.Scanner;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Confirmation extends Question<Boolean> {
    private final Supplier<Message> questionGenerator = messages(
            "I'm not sure I caught you: was it yes or no?",
            "Funny, I still don't understand, is it yes or no?",
            "Oh, it's too complicated for me: just tell me yes or no.",
            "Could you please simply say yes or no?",
            "Oh, no, don't try to confuse me: say yes or no."
    );

    private final ExpressionChecker yesChecker = ExpressionChecker.fromSet(
            "y", "yes", "yeah", "yep", "sure", "right", "affirmative", "correct", "indeed", "you bet", "exactly", "you said it"
    );

    private final ExpressionChecker noChecker = ExpressionChecker.fromSet(
            "n", "no", "no way", "nah", "nope", "negative", "I don't think so", "yeah no"
    );

    private final Scanner scanner;

    private final Message startQuestion;
    private boolean isFirst;

    public Confirmation(Scanner scanner, Message startQuestion) {
        super(scanner);
        this.scanner = scanner;
        this.startQuestion = startQuestion;
        this.isFirst = true;
    }

    @Override
    public Boolean read(Scanner sc) {
        String s = sc.nextLine();
        if (yesChecker.isExpression(s)) {
            return Boolean.TRUE;
        }
        if (noChecker.isExpression(s)) {
            return Boolean.FALSE;
        }
        return null;
    }

    @Override
    public Message question() {
        if (isFirst) {
            isFirst = false;
            return startQuestion;
        }
        return questionGenerator.get();
    }

    @Override
    public Scanner scanner() {
        return scanner;
    }

    private static Supplier<Message> messages(final String... questions) {
        Set<Message> msgs = Stream.of(questions)
                .map(SimpleMessage::new)
                .collect(Collectors.toSet());
        return RandomGenerator.random(msgs);
    }
}
