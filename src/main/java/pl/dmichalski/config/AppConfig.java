package pl.dmichalski.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.dmichalski.config.profiled.DevConfiguration;
import pl.dmichalski.config.profiled.LocalConfiguration;
import pl.dmichalski.config.profiled.ProdConfiguration;

/**
 * Created by rdas on 01/09/2016.
 */
@Import({LocalConfiguration.class,ProdConfiguration.class, DevConfiguration.class})
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"pl.dmichalski.bootstrap.controller"})
public class AppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
