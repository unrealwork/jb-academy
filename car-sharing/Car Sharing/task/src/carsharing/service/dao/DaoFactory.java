package carsharing.service.dao;

import carsharing.model.Car;
import carsharing.model.Company;

import java.sql.Statement;

public interface DaoFactory {
    Dao<Company> companies();

    CarDao cars();

    static DaoFactory fromJdbcStatement(final Statement statement) {
        return new DaoFactoryImpl(statement);
    }
}
