package carsharing.service.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SchemaUpdaterImpl implements SchemaUpdater {
    private final Statement statement;
    private final List<String> updatesQueries;

    public SchemaUpdaterImpl(Statement statement, List<String> updatesQueries) {
        this.statement = statement;
        this.updatesQueries = updatesQueries;
    }

    @Override
    public void update() throws SQLException {
        for (String updatesQuery : updatesQueries) {
            statement.execute(updatesQuery);
        }
    }
}
