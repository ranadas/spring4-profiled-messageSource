package pl.dmichalski.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

/**
 * Created by rdas on 01/09/2016.
 */
@Configuration
public class ViewConfig {
    @Bean
    public ViewResolver viewResolver() {
//    public UrlBasedViewResolver viewResolver() {
//        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
//        viewResolver.setViewClass(TilesView.class);
//        return viewResolver;

        InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
        viewResolve.setPrefix("/WEB-INF/jsp/");
        viewResolve.setSuffix(".jsp");

        return viewResolve;
    }

//    @Bean
//    public TilesConfigurer tilesConfigurer() {
//        TilesConfigurer tilesConfigurer = new TilesConfigurer();
//        tilesConfigurer.setDefinitions(new String[]{
////                "/WEB-INF/layouts/tiles.xml",
////                "/WEB-INF/views/**/tiles.xml"
//                "/WEB-INF/tiles/tiles-definitions.xml"
//
//        });
//        tilesConfigurer.setCheckRefresh(true);
//        return tilesConfigurer;
//    }
}
