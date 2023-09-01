package com.study.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class HomeController {
    @GetMapping("/")
    public String index(){
        return "welcome";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/req1")
    public String req1(){
        return "req1";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/req2")
    public String req2(@RequestParam String q1, @RequestParam("q2") int q2){
        return "welcome";
    }

    @GetMapping("/req3")
    public String req3(@RequestParam("p1") String p1, @RequestParam("p2") String p2){
        return "welcome";
    }
}
