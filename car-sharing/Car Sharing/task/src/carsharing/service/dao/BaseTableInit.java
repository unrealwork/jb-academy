package carsharing.service.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTableInit implements TableInit {
    private final Statement statement;
    private final Connection connection;
    private final String tableName;
    protected BaseTableInit(Statement statement, Connection connection, String tableName) {
        this.statement = statement;
        this.connection = connection;
        this.tableName = tableName;
    }

    @Override
    public void init() throws SQLException {
        List<String> tables = loadTableList(connection);
        if (!tables.contains(tableName)) {
            statement.execute(query());
        }
    }

    protected abstract String query();

    private static List<String> loadTableList(final Connection connection) throws SQLException {
        ResultSet res = connection.getMetaData().getTables(connection.getCatalog(), connection.getSchema(), null, new String[] {});
        List<String> tables = new ArrayList<>();
        while (res.next()) {
            tables.add(res.getString("TABLE_NAME"));
        }
        return tables;
    }
}
