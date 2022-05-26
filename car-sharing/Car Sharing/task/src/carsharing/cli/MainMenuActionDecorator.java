package carsharing.cli;

import java.util.Scanner;

class MainMenuActionDecorator<T extends MenuOption> extends AnswerActionDecorator<T> {
    MainMenuActionDecorator(ActionFactory factory, T... opts) {
        super(SimpleAnswerActionImpl.create(factory.scanner(), sc -> readOption(sc, opts)));
    }

    private static <T extends MenuOption> T readOption(Scanner scanner, T... options) {
        int opt = scanner.nextInt();
        scanner.nextLine();
        return MenuOption.fromNumber(opt, options);
    }
}
