package carsharing.cli;

import carsharing.model.Company;
import carsharing.service.dao.CarDao;

class CarMenu implements Action<Void> {
    private final ActionFactory actionFactory;
    private final Company company;
    private final CarMenuActionFactory carOptionFactory;

    CarMenu(ActionFactory actionFactory, CarDao carDao, Company company) {
        this.actionFactory = actionFactory;
        this.company = company;
        this.carOptionFactory = CarMenuActionFactory.create(actionFactory, carDao, company);
    }

    @Override
    public Void execute() {
        String title = "'" + company.getName() + "' company";
        actionFactory.message(title).execute();
        String menuText = MenuUtils.buildMenu(CarMenuOption.values());
        actionFactory.message(menuText).execute();
        CarMenuOption opt = actionFactory.menuOption(CarMenuOption.values()).execute();
        carOptionFactory.get(opt).execute();
        return null;
    }
}
