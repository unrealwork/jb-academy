package carsharing.cli;

import carsharing.model.Car;
import carsharing.model.Company;
import carsharing.service.dao.Dao;

public class CreateCarAction implements Action<Void> {
    private final ActionFactory actionFactory;
    private final Dao<Car> carDao;
    private final Company company;


    public CreateCarAction(ActionFactory actionFactory, Dao<Car> carDao, Company company) {
        this.actionFactory = actionFactory;
        this.carDao = carDao;
        this.company = company;
    }

    @Override
    public Void execute() {
        actionFactory.message("Enter the car name:").execute();
        String name = actionFactory.answer()
                .execute();
        carDao.create(new Car(name, company.getId()));
        actionFactory.message("The car was added!")
                .execute();
        actionFactory.carMenu(company)
                .execute();
        return null;
    }
}
