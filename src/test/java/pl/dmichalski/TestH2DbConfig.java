package pl.dmichalski;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.dmichalski.config.profiled.DevConfiguration;
import pl.dmichalski.config.profiled.LocalConfiguration;
import pl.dmichalski.config.profiled.ProdConfiguration;

/**
 * Created by rdas on 08/10/2016.
 */
@Import({LocalConfiguration.class})
//@ComponentScan({""})
@Configuration
public class TestH2DbConfig {
}
