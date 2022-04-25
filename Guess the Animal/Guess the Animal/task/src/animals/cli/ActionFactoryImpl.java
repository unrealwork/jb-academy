package animals.cli;

import animals.Fact;
import animals.MessageKeys;
import animals.MessageStorage;
import animals.Subject;
import animals.cli.greeting.GreetingMessage;

import java.io.InputStream;
import java.util.Scanner;

public class ActionFactoryImpl implements ActionFactory {
    private final Scanner scanner;
    private final MessageStorage storage;

    private ActionFactoryImpl(InputStream is) {
        this.scanner = new Scanner(is);
        this.storage = MessageStorage.def();
    }

    ActionFactoryImpl() {
        this(System.in);
    }


    @Override
    public Question<String> question(String question) {
        return new SimpleQuestion(question, scanner);
    }

    @Override
    public Action<Boolean> confirmation(Message startQuestion) {
        return new Confirmation(scanner, startQuestion);
    }

    @Override
    public Question<Subject> subjectQuestion(String s) {
        return new SubjectQuestion(s, scanner);
    }

    @Override
    public Message greetingMessage() {
        return new GreetingMessage();
    }

    @Override
    public Message message(String s) {
        return new SimpleMessage(s);
    }

    @Override
    public Action<String> animalRequest() {
        return new AnimalRequestAction(this);
    }

    @Override
    public Message randomMessage(String... messages) {
        return new RandomMessage(messages);
    }

    @Override
    public Message lineBreak() {
        return new LineBreakMessage();
    }

    @Override
    public Message byeMessage() {
        return new RandomMessage(storage.get(MessageKeys.BYE)
                .toArray(String[]::new));
    }

    @Override
    public Action<Fact> factRequest(String question, String confirmationMessage) {
        return new FactRequest(this, question, confirmationMessage);
    }

    @Override
    public void close() {
        scanner.close();
    }

    public static void main(String[] args) throws Exception {
        try(ActionFactory factory = ActionFactory.cli()) {
            factory.byeMessage()
                    .execute();
        }
    }
}
