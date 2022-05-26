package carsharing.service.dao;

import java.sql.Statement;
import java.util.List;

abstract class BaseDao<T> implements Dao<T> {
    protected Statement getStatement() {
        return statement;
    }

    private final Statement statement;

    BaseDao(Statement statement) {
        this.statement = statement;
    }

    protected abstract String tableName();
}
