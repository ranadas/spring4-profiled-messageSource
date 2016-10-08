package pl.dmichalski.bootstrap.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Daniel
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private Environment environment;

    @PostConstruct
    public void init() {

        System.out.println("\nActive Profile :  "+(Arrays.asList(environment.getActiveProfiles())).toString() + "\n");
        System.out.println("\nDefault Profile :  "+(Arrays.asList(environment.getDefaultProfiles())).toString()+ "\n");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getIndexPage(ModelMap model) {
        Gson gson = new Gson();

        Map<String, String> maps = new HashMap<>();
        maps.put("user", "Rana Das");
        maps.put("displayCanvas", "create"); // default mode

        model.put("user", gson.toJson(maps));
        System.out.println(model);

        return "index";
    }


}
