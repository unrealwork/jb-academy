package carsharing.cli;

import carsharing.model.Car;
import carsharing.model.Company;
import carsharing.service.dao.CarDao;
import carsharing.service.dao.Dao;

import java.util.List;

public class ListCarAction implements Action<Void> {
    private final ActionFactory actionFactory;
    private final CarDao carDao;

    private final Company company;

    public ListCarAction(ActionFactory actionFactory, CarDao carDao, Company company) {
        this.actionFactory = actionFactory;
        this.carDao = carDao;
        this.company = company;
    }

    @Override
    public Void execute() {
        List<Car> carList = carDao.findByCompanyId(company.getId());

        actionFactory.message(carListDesc(carList))
                .execute();
        actionFactory.carMenu(company)
                .execute();
        return null;
    }

    private static String carListDesc(final List<Car> carList) {
        if (carList.isEmpty()) {
            return "The car list is empty!";
        }
        StringBuilder desc = new StringBuilder();
        desc.append("Car list:")
                .append(System.lineSeparator());
        for (int i = 0; i < carList.size(); i++) {
            desc.append(i + 1)
                    .append(". ")
                    .append(carList.get(i).getName())
                    .append(System.lineSeparator());
        }
        return desc.toString();
    }
}

