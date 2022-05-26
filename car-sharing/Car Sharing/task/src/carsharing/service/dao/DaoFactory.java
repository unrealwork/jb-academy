package carsharing.service.dao;

import carsharing.model.Company;

import java.sql.Statement;

public interface DaoFactory {
    Dao<Company> companies();

    static DaoFactory fromJdbcStatement(final Statement statement) {
        return new DaoFactoryImpl(statement);
    }
}
