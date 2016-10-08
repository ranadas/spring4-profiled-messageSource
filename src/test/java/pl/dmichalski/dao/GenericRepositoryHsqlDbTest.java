package pl.dmichalski.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.dmichalski.TestH2DbConfig;
import pl.dmichalski.model.Customer;

import java.sql.SQLException;


/**
 * Created by rdas on 08/10/2016.
 */
@ActiveProfiles("prod")
@ContextConfiguration(classes ={TestH2DbConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GenericRepositoryHsqlDbTest {

    @Autowired
    private GenericRepository genericRepository;

    private Customer customer;

    @Before
    public void init() {
        customer = Customer.builder().name("Rana").version(11).credit(999).build();
    }

    @Test
    public void testPlainJdbcInsert() throws SQLException{
        long i = genericRepository.saveCompanyPlainJdbc(customer);
        System.out.println(i);
    }

    @Test
    public void testSpringJdbcTemplateInsert() throws SQLException{
        long i = genericRepository.saveCompanyJdbcTemplate(customer);
        System.out.println(i);

    }

    @Test
    public void testSpringNamedTemplateInsert() throws SQLException{
        long i = genericRepository.saveCompanyNamedParameter(customer);
        System.out.println(i);

    }
}