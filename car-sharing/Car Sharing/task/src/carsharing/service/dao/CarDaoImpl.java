package carsharing.service.dao;

import carsharing.model.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static carsharing.service.dao.Util.concatObjects;

public class CarDaoImpl extends BaseDao<Car> implements CarDao {
    CarDaoImpl(Statement statement) {
        super(statement);
    }

    @Override
    protected String tableName() {
        return "CAR";
    }

    @Override
    public void create(Car entity) {
        String query =
                MessageFormat.format("INSERT INTO {0} (NAME, COMPANY_ID) VALUES ({1});", tableName(), asValues(entity));
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    @Override
    public List<Car> list() {
        String query = MessageFormat.format(
                "SELECT * FROM {0}", tableName());
        try {
            final ResultSet rs = getStatement().executeQuery(query);
            return readCars(rs);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private List<Car> readCars(ResultSet rs) throws SQLException {
        List<Car> cars = new ArrayList<>();
        while (rs.next()) {
            cars.add(rowFromResult(rs));
        }
        return Collections.unmodifiableList(cars);
    }

    private static String asValues(Car company) {
        return concatObjects(
                "'" + company.getName() + "'",
                company.getCompanyId()
        );
    }


    private static Car rowFromResult(ResultSet rs) throws SQLException {
        return new Car(rs.getInt("ID"), rs.getString("NAME"), rs.getInt("COMPANY_ID"));
    }

    @Override
    public List<Car> findByCompanyId(int companyId) {
        String sqlQuery = MessageFormat.format(
                "SELECT * FROM CAR" +
                        " WHERE COMPANY_ID = {0};", companyId
        );
        try {
            return readCars(getStatement().executeQuery(sqlQuery));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
