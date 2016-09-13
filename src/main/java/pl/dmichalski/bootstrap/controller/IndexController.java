package pl.dmichalski.bootstrap.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Daniel
 */
@Controller
@RequestMapping("/")
public class IndexController {

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

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "datas")
    public String getDatas(ModelMap model) {
        System.out.println(model);

        Gson gson = new Gson();

        Map<String, String> map1 = new HashMap<>();
        map1.put("rank", "1");
        map1.put("user", "Rana Das");
        map1.put("email", "rdas@email.com");

        Map<String, String> map2 = new HashMap<>();
        map2.put("rank", "10");
        map2.put("user", "Jennifer Simonetti");
        map2.put("email", "jen@email.com");


        Map<String, String> map3 = new HashMap<>();
        map3.put("rank", "100");
        map3.put("user", "Connal Murphy");
        map3.put("email", "connal@email.com");

        List<Map<String, String>> mapList = new ArrayList<>();
        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);

        return gson.toJson(mapList);
    }
}
