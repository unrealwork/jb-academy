package carsharing.cli;

import carsharing.Main;
import carsharing.model.Company;
import carsharing.service.dao.Dao;

import java.util.List;
import java.util.Scanner;

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
        List<Company> companies = companyDao.list();
        if (companies.isEmpty()) {
            actionFactory.message("The company list is empty!")
                    .execute();
        } else {
            StringBuilder companiesDesc = new StringBuilder("Choose the company:");
            companiesDesc.append(System.lineSeparator());
            for (int i = 0; i < companies.size(); i++) {
                companiesDesc.append(i + 1)
                        .append(". ")
                        .append(companies.get(i).getName())
                        .append(System.lineSeparator());
            }
            actionFactory.message(companiesDesc.toString())
                    .execute();
            actionFactory.message("0. Back").execute();
            int i = actionFactory.answer(Scanner::nextInt)
                    .execute();
            if (i == 0) {
                actionFactory.menuAction(MainMenuOption.LOGIN).execute();
            } else {
                actionFactory.carMenu(companies.get(i - 1))
                        .execute();
            }

        }
        menuActionFactory.get(MainMenuOption.LOGIN).execute();
        return null;
    }
}
