package carsharing.service.dao;

import carsharing.model.Company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class CompanyDaoImpl extends BaseDao<Company> {
    public CompanyDaoImpl(Statement statement) {
        super(statement);
    }

    @Override
    protected String tableName() {
        return "COMPANY";
    }


    @Override
    public void create(Company entity) {
        String query =
                MessageFormat.format("INSERT INTO {0} (name) VALUES ({1});", tableName(), asValues(entity));
        try {
            getStatement().execute(query);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }

    @Override
    public List<Company> list() {
        String query = MessageFormat.format(
                "SELECT * FROM {0}", tableName());
        try {
            final ResultSet rs = getStatement().executeQuery(query);
            List<Company> companies = new ArrayList<>();
            while (rs.next()) {
                companies.add(rowFromResult(rs));
            }
            return Collections.unmodifiableList(companies);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private static String asValues(Company company) {
        Object[] objs = {"'" + company.getName() + "'"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objs.length; i++) {
            sb.append(objs[i]);
            if (i != objs.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private static Company rowFromResult(ResultSet rs) throws SQLException {
        return new Company(rs.getInt("ID"), rs.getString("NAME"));
    }
}
