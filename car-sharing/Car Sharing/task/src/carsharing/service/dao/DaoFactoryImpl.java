package carsharing.service.dao;

import carsharing.model.Company;

import java.sql.Statement;

class DaoFactoryImpl implements DaoFactory {
    private final Statement statement;

    DaoFactoryImpl(Statement statement) {
        this.statement = statement;
    }

    @Override
    public Dao<Company> companies() {
        return new CompanyDaoImpl(statement);
    }
}
