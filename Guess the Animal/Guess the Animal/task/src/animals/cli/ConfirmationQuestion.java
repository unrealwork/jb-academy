package animals.cli;

import animals.storage.MessageKeys;
import animals.storage.MessageStorage;

import java.util.Scanner;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ConfirmationQuestion extends Question<Boolean> {
    private final Supplier<Message> questionGenerator;


    private final ExpressionChecker yesChecker;
    private final ExpressionChecker noChecker;
    private final Scanner scanner;

    private final Message startQuestion;
    private boolean isFirst;

    public ConfirmationQuestion(Scanner scanner, Message startQuestion, MessageStorage storage) {
        super(scanner);
        this.scanner = scanner;
        this.startQuestion = startQuestion;
        this.isFirst = true;
        // TODO: Flyweight for checkers, no need to recreate this objects
        this.yesChecker = ExpressionChecker.fromSet(
                storage.get(MessageKeys.YES)
        );
        this.noChecker = ExpressionChecker.fromSet(
                storage.get(MessageKeys.NO)
        );

        this.questionGenerator = messages(
                storage.get(MessageKeys.NOT_SURE));
    }

    @Override
    public Boolean read(Scanner sc) {
        String s = sc.nextLine();
        Boolean res = null;
        if (yesChecker.isExpression(s)) {
            res = Boolean.TRUE;
        }
        if (noChecker.isExpression(s)) {
            res = Boolean.FALSE;
        }
        return res;
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

    private static Supplier<Message> messages(final Set<String> messages) {
        Set<Message> msgs = messages.stream()
                .map(SimpleMessage::new)
                .collect(Collectors.toSet());
        return RandomGenerator.random(msgs);
    }
}
