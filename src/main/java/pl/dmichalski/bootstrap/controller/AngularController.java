package pl.dmichalski.bootstrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmichalski.services.BlogPersistService;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by rdas on 12/09/2016.
 */
@Controller
public class AngularController {


    @Autowired
    public BlogPersistService blogPersistService;

    @RequestMapping(method = RequestMethod.GET, path = "ang")
    public String getIndexPage(ModelMap model) throws Exception {
//        Gson gson = new Gson();

//        Map<String, String> maps = new HashMap<>();
//        maps.put("user", "Rana Das");
//        maps.put("displayCanvas", "create"); // default mode
//
//        model.put("user", gson.toJson(maps));
        System.out.println(model);
        blogPersistService.save();
        return "ang-index";
    }
}
