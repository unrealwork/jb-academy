package carsharing.cli;

import carsharing.model.Company;
import carsharing.service.dao.DaoFactory;

import java.util.Scanner;
import java.util.function.Function;

class CliActionFactoryImpl implements ActionFactory {

    private final DaoFactory daoFactory;
    private final Scanner scanner = new Scanner(System.in);

    private final MenuActionFactory menuActionFactory;

    CliActionFactoryImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
        this.menuActionFactory = new MenuActionFactoryImpl(this, daoFactory.companies());
    }


    @Override
    public Action<Void> message(String message) {
        return new CliMessageAction(System.out, message);
    }

    @Override
    public <T> Action<T> answer(Function<Scanner, T> reader) {
        return SimpleAnswerActionImpl.create(scanner, reader);
    }

    @Override
    public Scanner scanner() {
        return scanner;
    }

    @Override
    public Action<Void> carMenu(Company company) {
        return new CarMenu(this, daoFactory.cars(), company);
    }

    @Override
    public Action<Void> menuAction(MenuOption option) {
        return menuActionFactory.get(option);
    }

    @Override
    public void close() {
        scanner.close();
    }
}
