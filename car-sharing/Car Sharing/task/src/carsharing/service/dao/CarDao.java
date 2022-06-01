package carsharing.service.dao;

import carsharing.model.Car;

import java.util.List;

public interface CarDao extends Dao<Car> {
    List<Car> findByCompanyId(final int companyId);
}
