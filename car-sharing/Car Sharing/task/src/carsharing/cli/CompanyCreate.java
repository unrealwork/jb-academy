package carsharing.cli;

import carsharing.model.Company;
import carsharing.service.dao.Dao;

public class CompanyCreate implements Action<Void> {
    private final ActionFactory actionFactory;
    private final Dao<Company> dao;
    private final MenuActionFactory menuActionFactory;

    public CompanyCreate(ActionFactory actionFactory, Dao<Company> dao, MenuActionFactory menuActionFactory) {
        this.actionFactory = actionFactory;
        this.dao = dao;
        this.menuActionFactory = menuActionFactory;
    }

    @Override
    public Void execute() {
        actionFactory.message("Enter the company name:")
                .execute();
        String name = actionFactory.answer().execute();
        dao.create(new Company(name));
        actionFactory.message("The company was created!");
        menuActionFactory.get(MainMenuOption.LOGIN).execute();
        return null;
    }
}
