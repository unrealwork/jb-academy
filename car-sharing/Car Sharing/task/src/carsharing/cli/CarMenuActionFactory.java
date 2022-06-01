package carsharing.cli;

import carsharing.model.Company;
import carsharing.service.dao.CarDao;

final class CarMenuActionFactory {
    private final ActionFactory actionFactory;
    private final CarDao carDao;
    private final Company company;


    private CarMenuActionFactory(ActionFactory actionFactory, CarDao carDao, Company company) {
        this.actionFactory = actionFactory;
        this.carDao = carDao;
        this.company = company;
    }

    static CarMenuActionFactory create(ActionFactory actionFactory, CarDao carDao, Company company) {
        return new CarMenuActionFactory(actionFactory, carDao, company);
    }

    public Action<Void> get(CarMenuOption option) {
        switch (option) {
            case CREAT:
                return new CreateCarAction(actionFactory, carDao, company);
            case LIST:
                return new ListCarAction(actionFactory, carDao, company);
            default:
                return actionFactory.menuAction(MainMenuOption.LOGIN);

        }
    }

}
