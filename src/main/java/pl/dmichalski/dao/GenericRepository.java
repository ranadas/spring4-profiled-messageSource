package pl.dmichalski.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Repository;
import pl.dmichalski.model.Customer;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;

/**
 * Created by rdas on 08/10/2016.
 */
@Repository
public class GenericRepository {
    private static final String INSERT_SQL = "INSERT INTO MBTOOWNER.CUSTOMER (CUSTOMER_ID, VERSION, NAME, CREDIT) VALUES (MBTOOWNER.CUSTOMER_SEQ.nextval, ?, ?, ?)";
    private static final String INSERT_NAMED_SQL = "INSERT INTO MBTOOWNER.CUSTOMER (CUSTOMER_ID, VERSION, NAME, CREDIT) VALUES (MBTOOWNER.CUSTOMER_SEQ.nextval, :version, :name, :credit)";
    private static final String SELECT_ALL = "SELECT * FROM MBTOOWNER.CUSTOMER";
    private static final String SELECT_FOR_NAME = "SELECT * FROM MBTOOWNER.CUSTOMER WHERE NAME = ?";

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() throws SQLException {
        System.out.println("\n using " + dataSource.getConnection() + "\n");
    }

    public long saveCompanyPlainJdbc(Customer company) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = preparedStatement(connection, INSERT_SQL, company)) {
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        }
        return company.getCustomerId();
    }

    private PreparedStatement preparedStatement(Connection connection, String sql, Customer customer) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, customer.getVersion());
        preparedStatement.setString(2, customer.getName());
        preparedStatement.setLong(3, customer.getCredit());
        return preparedStatement;
    }

    public long saveCompanyJdbcTemplate(Customer customer) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        long version = customer.getVersion();
        String name = customer.getName();
        long credit = customer.getCredit();
        Object[] params = new Object[]{version, name, credit};
        int[] types = new int[]{Types.LONGNVARCHAR, Types.VARCHAR, Types.LONGNVARCHAR};

        int row = template.update(INSERT_SQL, params, types);
        System.out.println(row + " row inserted.");
        return row;
    }

    public long saveCompanyNamedParameter(Customer customer) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        Map namedParameters = new HashMap();
        namedParameters.put("version", customer.getVersion());
        namedParameters.put("name", customer.getName());
        namedParameters.put("credit", customer.getCredit());
        int update = namedParameterJdbcTemplate.update(INSERT_NAMED_SQL, namedParameters);
        System.out.println(update + " row inserted.");
        return update;
    }

    public Optional<List<Customer>> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();

        new JdbcTemplate(new SingleConnectionDataSource(dataSource.getConnection(), true))
                // lambda expressions as RowMappers
                .query(SELECT_ALL, (rs, rowNum) ->
                        Customer.builder().customerId(rs.getLong("CUSTOMER_ID"))
                                .version(rs.getLong("VERSION"))
                                .name(rs.getString("NAME"))
                                .credit(rs.getLong("CREDIT"))
                                .build()
                )
                .forEach(c -> customers.add(c));
        return Optional.of(customers);
    }

    public Optional<List<Customer>> getCustomersWithNamesLike(String name) throws SQLException {
        List<Customer> customers = new ArrayList<>();

        new JdbcTemplate(new SingleConnectionDataSource(dataSource.getConnection(), true))
                //lambda expressions as RowMappers
                .query(SELECT_FOR_NAME, new Object[]{name}, (rs, rowNum) ->
                        Customer.builder().customerId(rs.getLong("CUSTOMER_ID"))
                                .version(rs.getLong("VERSION"))
                                .name(rs.getString("NAME"))
                                .credit(rs.getLong("CREDIT"))
                                .build()
                )
                .forEach(c -> customers.add(c));

        return Optional.of(customers);
    }
}