package animals.cli;

import java.util.Scanner;

public class SimpleQuestion extends Question<String> {
    private final Message questionMessage;

    public SimpleQuestion(String question, Scanner scanner) {
        super(scanner);
        questionMessage = new SimpleMessage(question);
    }

    @Override
    public String read(Scanner sc) {
        return sc.nextLine();
    }

    @Override
    public Message question() {
        return questionMessage;
    }
}
