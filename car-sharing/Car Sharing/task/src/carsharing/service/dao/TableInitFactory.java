package carsharing.service.dao;

import java.sql.Connection;
import java.sql.Statement;

public class TableInitFactory {
    private final Connection connection;
    private final Statement statement;

    public TableInitFactory(Connection connection, Statement statement) {
        this.connection = connection;
        this.statement = statement;
    }

    public TableInit company() {
        return new CompanyBaseTableInit(statement, connection);
    }

    public static TableInitFactory create(Connection c, Statement s) {
        return new TableInitFactory(c, s);
    }

    public TableInit car() {
        return new CarTableInitImpl(statement, connection);
    }
    
    public TableInit customer() {
        return new CustomerTableInitImpl(statement, connection);
    }
}
