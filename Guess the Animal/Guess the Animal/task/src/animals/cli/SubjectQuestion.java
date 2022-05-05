package animals.cli;

import animals.lang.Expression;
import animals.lang.Subject;

import java.util.Scanner;

public class SubjectQuestion extends Question<Subject> {
    private final Message message;

    public SubjectQuestion(String message, Scanner scanner) {
        super(scanner);
        this.message = new SimpleMessage(message);
    }

    @Override
    public Subject read(Scanner sc) {
        Expression exp = Expression.parse(sc.nextLine());
        return new Subject(exp);
    }

    @Override
    public Message question() {
        return message;
    }
}
