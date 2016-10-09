package pl.dmichalski.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.dmichalski.TestHsqlDbConfig;
import pl.dmichalski.model.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by rdas on 08/10/2016.
 */
@ActiveProfiles("prod")
@ContextConfiguration(classes ={TestHsqlDbConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GenericRepositoryHsqlDbTest {

    @Autowired
    private GenericRepository genericRepository;

    @Before
    public void init() {
    }

    @Test
    public void test_1_GetAll() throws SQLException{
        Optional<List<Customer>> allCustomers = genericRepository.getAllCustomers();
        assertThat(allCustomers.isPresent(), is(true));
        assertThat(allCustomers.get().size(), is(1));
    }
}