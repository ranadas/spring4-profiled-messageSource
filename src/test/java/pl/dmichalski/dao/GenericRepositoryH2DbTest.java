package pl.dmichalski.dao;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.dmichalski.TestH2DbConfig;
import pl.dmichalski.model.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by rdas on 08/10/2016.
 */
@ActiveProfiles("local")
@ContextConfiguration(classes ={TestH2DbConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenericRepositoryH2DbTest {

    @Autowired
    private GenericRepository genericRepository;

    private Customer customer;

    @Before
    public void init() {
        customer = Customer.builder().name("Rana").version(11).credit(999).build();
    }

    @Test
    public void test_1_PlainJdbcInsert() throws SQLException{
        long i = genericRepository.saveCompanyPlainJdbc(customer);
        System.out.println(i);
        Optional<List<Customer>> allCustomers = genericRepository.getAllCustomers();
        assertThat(allCustomers.isPresent(), is(true));
        assertThat(allCustomers.get().size(), is(5));
    }

    @Test
    public void test_2_SpringJdbcTemplateInsert() throws SQLException{
        long i = genericRepository.saveCompanyJdbcTemplate(customer);
        System.out.println(i);
        Optional<List<Customer>> allCustomers = genericRepository.getAllCustomers();
        assertThat(allCustomers.isPresent(), is(true));
        assertThat(allCustomers.get().size(), is(6));
    }

    @Test
    public void test_3_SpringNamedTemplateInsert() throws SQLException{
        long i = genericRepository.saveCompanyNamedParameter(customer);


        Optional<List<Customer>> allCustomers = genericRepository.getAllCustomers();
        assertThat(allCustomers.isPresent(), is(true));
        assertThat(allCustomers.get().size(), is(7));
    }

    @Test
    public void test_4_SpringSelectAllCustomers() throws SQLException{
        Optional<List<Customer>> allCustomers = genericRepository.getAllCustomers();
        System.out.println(allCustomers);
        assertThat(allCustomers.isPresent(), is(true));
        assertThat(allCustomers.get().size(), is(7));
    }
}