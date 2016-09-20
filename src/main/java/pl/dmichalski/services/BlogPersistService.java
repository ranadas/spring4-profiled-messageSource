package pl.dmichalski.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by rdas on 20/09/2016.
 */
@Service
public class BlogPersistService {

    @Autowired
    public DataSource dataSource;

    @PostConstruct
    public void init() throws SQLException {
        System.out.println("\n\n----BlogPersistService-> "+dataSource.getConnection().toString());
    }

    public void save() throws Exception {
        System.out.println("\n\n--SAVING --BlogPersistService-> "+dataSource.getConnection().toString());
    }

}
