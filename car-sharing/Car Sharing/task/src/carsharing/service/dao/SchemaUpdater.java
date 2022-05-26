package carsharing.service.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public interface SchemaUpdater {
    void update() throws SQLException;

    static SchemaUpdater fromQueries(Statement statement, String... queries) {
        return new SchemaUpdaterImpl(statement, Arrays.asList(queries));
    }
}
