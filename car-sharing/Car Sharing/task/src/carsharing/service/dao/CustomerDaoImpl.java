package carsharing.service.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.List;

import carsharing.model.Customer;

import static carsharing.service.dao.Util.concatObjects;

public class CustomerDaoImpl extends BaseDao<Customer> {
    CustomerDaoImpl(Statement statement) {
        super(statement);
    }

    @Override
    public void create(Customer entity) {
        String query =
                MessageFormat.format("INSERT INTO {0} (NAME, RENTED_CAR_ID) VALUES ({1},{2});", tableName(), asValues(entity));
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private String asValues(Customer entity) {
        return concatObjects(
                "'" + entity.getName() + "'",
                entity.getRentedCarId()
        );
    }

    @Override
    public List<Customer> list() {
        return null;
    }

    @Override
    protected String tableName() {
        return "CUSTOMER";
    }
}
