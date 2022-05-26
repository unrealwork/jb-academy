package carsharing.cli;

import carsharing.model.Company;
import carsharing.service.dao.Dao;

import java.util.List;

public class CompanyList implements Action<Void> {
    private final ActionFactory actionFactory;
    private final Dao<Company> companyDao;

    private final MenuActionFactory menuActionFactory;

    public CompanyList(ActionFactory actionFactory, Dao<Company> companyDao, MenuActionFactory menuActionFactory) {
        this.actionFactory = actionFactory;
        this.companyDao = companyDao;
        this.menuActionFactory = menuActionFactory;
    }

    @Override
    public Void execute() {
        StringBuilder companiesDesc = new StringBuilder();
        List<Company> companies = companyDao.list();
        if (companies.isEmpty()) {
            actionFactory.message("The company list is empty!")
                    .execute();
        } else {
            for (int i = 0; i < companies.size(); i++) {
                companiesDesc.append(i + 1)
                        .append(". ")
                        .append(companies.get(i).getName())
                        .append(System.lineSeparator());
            }
            actionFactory.message(companiesDesc.toString())
                    .execute();

        }
        menuActionFactory.get(MainMenuOption.LOGIN).execute();
        return null;
    }
}
