package pl.dmichalski.bootstrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rdas on 12/09/2016.
 */
@Controller
public class DTablesController {

    @RequestMapping(method = RequestMethod.GET, path = "dt")
    public String getIndexPage(ModelMap model) {
        System.out.println(model);

        return "dtables";
    }
}
