package animals.cli;

import animals.cli.menu.MenuAction;
import animals.cli.menu.MenuOption;
import animals.cli.menu.MenuService;
import animals.lang.Fact;
import animals.storage.MessageKeys;
import animals.storage.MessageStorage;
import animals.lang.Subject;
import animals.lang.Template;
import animals.cli.greeting.GreetingMessage;

import java.io.InputStream;
import java.util.Scanner;

import static animals.storage.MessageKeys.FACT_TEMPLATE;

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
    public Action<Boolean> confirmationQuestion(Message startQuestion) {
        return new ConfirmationQuestion(scanner, startQuestion, storage);
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
    public Action<Fact> animalDiffRequest(Subject firstAnimal, Subject secondAnimal) {
        final String question = storage.template(FACT_TEMPLATE, firstAnimal.asText().toLowerCase(), secondAnimal.asText().toLowerCase());
        final String confirmationMessage = storage.find(MessageKeys.FACT_CONFIRM);
        return factRequest(question, confirmationMessage);
    }

    @Override
    public Action<Boolean> predicateQuestion(String question) {
        return new PredicateQuestion(this, storage, question);
    }

    @Override
    public Message animalFactDescription(Fact fact, Subject animal1, Subject animal2, boolean isAboutSecond) {
        final Template template = storage.template(MessageKeys.FACT_DESCRIPTION);
        return new AnimalFactDescription(template, fact, animal1, animal2, isAboutSecond);
    }

    @Override
    public Action<MenuOption> menuAction(MenuService menuService) {
        return new MenuAction(scanner, menuService);
    }


    @Override
    public void close() {
        scanner.close();
    }
}
