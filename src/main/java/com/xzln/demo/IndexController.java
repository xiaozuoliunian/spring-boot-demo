package com.xzln.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@Controller
@EnableAutoConfiguration
public class IndexController {

    @RequestMapping("/rest")
    @ResponseBody
    public Map<String, Object> index(){
        Map<String, Object> map = new HashMap<>(2);
        map.put("1", "wang");
        map.put("2", "li");
        return map;
    }

}
