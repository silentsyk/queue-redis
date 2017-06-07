package com.funnyy.component.queue.queueredis.service.impl;

import com.funnyy.component.queue.queueredis.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sky on 17-5-12.
 */
@Service
@RequestMapping("/test")
@Controller
public class HelloServiceImpl implements HelloService {

    @Override
    @ResponseBody
    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.POST})
    public Map sayHello(String name) {
        Map map = new HashMap();
        map.put("name", "syk");
        map.put("hello", "hello");
        return map;
    }

    @RequestMapping(value = "/no/{name}", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String sayNo(@PathVariable("name") String name) {
        return "no," + name;
    }
}
