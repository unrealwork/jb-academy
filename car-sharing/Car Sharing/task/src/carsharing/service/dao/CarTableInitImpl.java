package carsharing.service.dao;

import java.sql.Connection;
import java.sql.Statement;

public class CarTableInitImpl extends BaseTableInit {

    public CarTableInitImpl(Statement statement, Connection connection) {
        super(statement, connection, "CAR");
    }

    @Override
    protected String query() {
        return "CREATE TABLE CAR (" +
                " ID INT PRIMARY KEY AUTO_INCREMENT," +
                " NAME VARCHAR UNIQUE NOT NULL," +
                " COMPANY_ID INT NOT NULL," +
                " FOREIGN KEY (company_id) REFERENCES company(id)" +
                ")";
    }
}
