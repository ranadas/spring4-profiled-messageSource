package pl.dmichalski.config.profiled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Component;
import pl.dmichalski.config.DatabaseConfig;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * Created by rdas on 19/09/2016.
 */
@Configuration
@Profile("dev")
public class DevDatabaseConfig implements DatabaseConfig{

    @PostConstruct
    public void initBean() {
        System.out.println("\n\n\n\n ---> Initialising Dev Db Bean!! \n\n");
    }

    @Qualifier("devDatabase")
    @Autowired
    private DataSource dataSource;

    @Profile("dev")
    @Bean(name = "devDatabase")
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
//                .addScript("db/sql/create-db.sql")
//                .addScript("db/sql/insert-data.sql")
                .build();
        return db;
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }
}
