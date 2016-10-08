package pl.dmichalski;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.dmichalski.config.profiled.ProdConfiguration;

/**
 * Created by rdas on 08/10/2016.
 */
@Import({ProdConfiguration.class})
@Configuration
public class TestHsqlDbConfig {
}
