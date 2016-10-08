package pl.dmichalski.config.profiled;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Created by rdas on 08/10/2016.
 */
@Profile("dev")
@Configuration
public class DevConfiguration {

    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("app-prod");
        messageSource.setCacheSeconds(5);
        return messageSource;
    }
}
