package pl.dmichalski.config;

import javax.sql.DataSource;

/**
 * Created by rdas on 20/09/2016.
 */
public interface DatabaseConfig {
    DataSource getDataSource();
}
