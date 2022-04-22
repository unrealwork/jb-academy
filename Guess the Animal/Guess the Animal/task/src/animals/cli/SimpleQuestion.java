package animals.cli;

import java.util.Scanner;

public class SimpleQuestion extends Question<String> {
    private final Message questionMessage;
    private final Scanner scanner;

    public SimpleQuestion(String question, Scanner scanner) {
        questionMessage = new SimpleMessage(question);
        this.scanner = scanner;
    }

    @Override
    public String read(Scanner sc) {
        return sc.nextLine();
    }

    @Override
    public Message question() {
        return questionMessage;
    }

    @Override
    public Scanner scanner() {
        return scanner;
    }
}
