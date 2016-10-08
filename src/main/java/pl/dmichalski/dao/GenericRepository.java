package pl.dmichalski.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by rdas on 08/10/2016.
 */
@Repository
public class GenericRepository {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() throws SQLException {
        System.out.println("\n using "+dataSource.getConnection()+"\n");
    }


}
