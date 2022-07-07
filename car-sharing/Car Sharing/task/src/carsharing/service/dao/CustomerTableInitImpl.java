package carsharing.service.dao;

import java.sql.Connection;
import java.sql.Statement;

public class CustomerTableInitImpl extends BaseTableInit {
    protected CustomerTableInitImpl(Statement statement, Connection connection) {
        super(statement, connection, "CUSTOMER");
    }

    @Override
    protected String query() {
        return "CREATE TABLE CUSTOMER (" +
                " ID INT PRIMARY KEY AUTO_INCREMENT," +
                " NAME VARCHAR UNIQUE NOT NULL," +
                " RENTED_CAR_ID INT," +
                " FOREIGN KEY (rented_car_id) REFERENCES car(id))";
    }
}
