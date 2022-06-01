package carsharing;

import carsharing.cli.ActionFactory;
import carsharing.config.AppConfig;
import carsharing.service.dao.DaoFactory;
import carsharing.service.dao.SchemaUpdater;
import carsharing.service.dao.TableInitFactory;

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
    private final Connection connection;
    private final Statement statement;
    private final DaoFactory daoFactory;
    private final ActionFactory actionFactory;
    private final SchemaUpdater schemaUpdater;
    private final TableInitFactory tableInitFactory;

    private App(AppConfig config) throws SQLException, ClassNotFoundException {
        this.connection = createConnection(config);
        connection.setAutoCommit(true);
        this.statement = connection.createStatement();
        this.daoFactory = DaoFactory.fromJdbcStatement(statement);
        this.actionFactory = ActionFactory.cli(daoFactory);
        this.schemaUpdater = SchemaUpdater.fromQueries(statement);
        this.tableInitFactory = TableInitFactory.create(connection, statement);
    }

    static App create(AppConfig config) throws SQLException, ClassNotFoundException {
        return new App(config);
    }

    public void start() {
        try {
            tableInitFactory.company().init();
            tableInitFactory.car().init();
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

    private static Connection createConnection(AppConfig config) throws SQLException {
        Path path = Paths.get(AppConfig.DB_DIR, config.getDatabaseFileName()).toAbsolutePath();
        return DriverManager.getConnection("jdbc:h2:" + path);
    }

}
