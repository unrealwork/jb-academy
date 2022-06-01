package carsharing.service.dao;

import java.sql.Connection;
import java.sql.Statement;

class CompanyBaseTableInit extends BaseTableInit {
    private static final String CREATE_TABLE_COMPANY =
            "CREATE TABLE COMPANY(ID INT PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR UNIQUE NOT NULL);";

    public CompanyBaseTableInit(Statement statement, Connection connection) {
        super(statement, connection, "COMPANY");
    }

    @Override
    protected String query() {
        return CREATE_TABLE_COMPANY;
    }
}
