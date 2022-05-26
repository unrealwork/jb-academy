package carsharing;

import carsharing.cli.ActionFactory;
import carsharing.config.AppConfig;
import carsharing.service.dao.DaoFactory;
import carsharing.service.dao.SchemaUpdater;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class App implements AutoCloseable {
    private static final String CREATE_TABLE_COMPANY = "CREATE TABLE COMPANY(ID INT PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR UNIQUE NOT NULL);";

    public static final String TABLE_NAME = "COMPANY";
    private final Connection connection;
    private final Statement statement;
    private final DaoFactory daoFactory;
    private final ActionFactory actionFactory;
    private final SchemaUpdater schemaUpdater;

    private App(AppConfig config) throws SQLException, ClassNotFoundException {
        this.connection = createConnetion(config);
        connection.setAutoCommit(true);
        this.statement = connection.createStatement();
        this.daoFactory = DaoFactory.fromJdbcStatement(statement);
        this.actionFactory = ActionFactory.cli();
        this.schemaUpdater = SchemaUpdater.fromQueries(statement);
    }

    static App create(AppConfig config) throws SQLException, ClassNotFoundException {
        return new App(config);
    }
    public void start() {
        try {
            List<String> tables = loadTableList(connection);
            if (!tables.contains(TABLE_NAME)) {
                statement.execute(CREATE_TABLE_COMPANY);
            }
            schemaUpdater.update();
            actionFactory
                    .app(daoFactory.companies())
                    .execute();

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException, IOException {
        statement.close();
        connection.close();
        actionFactory.close();
    }

    private static Connection createConnetion(AppConfig config) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Path path = Paths.get(AppConfig.DB_DIR, config.getDatabaseFileName()).toAbsolutePath();
        return DriverManager.getConnection("jdbc:h2:" + path);
    }

    private static List<String> loadTableList(final Connection connection) throws SQLException {
        ResultSet res = connection.getMetaData().getTables(connection.getCatalog(), connection.getSchema(), null, new String[] {});
        List<String> tables = new ArrayList<>();
        while (res.next()) {
            tables.add(res.getString("TABLE_NAME"));
        }
        return tables;
    }
}
