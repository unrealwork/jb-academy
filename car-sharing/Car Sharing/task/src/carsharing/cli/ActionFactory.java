package carsharing.cli;

import carsharing.model.Company;
import carsharing.service.dao.Dao;

import java.io.Closeable;
import java.util.Scanner;
import java.util.function.Function;

public interface ActionFactory extends Closeable {
    Action<Void> message(final String message);

    <T> Action<T> answer(final Function<Scanner, T> reader);

    default <T extends MenuOption> Action<T> menuOption(T... opts) {
        return new MainMenuActionDecorator<>(this, opts);
    }

    default Action<String> answer() {
        return answer(Scanner::nextLine);
    }

    default Action<Void> app(Dao<Company> dao) {
        return new MainMenu(this, new MenuActionFactoryImpl(this, dao));
    }

    static ActionFactory cli() {
        return new CliActionFactoryImpl();
    }
    
    Scanner scanner();
}
