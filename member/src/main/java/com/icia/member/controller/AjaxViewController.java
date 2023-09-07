package com.icia.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AjaxViewController {
    @GetMapping("/ajax")
    public String index() {
        return "/ajaxView/index";
    }

    @GetMapping("/ajax-view01")
    public String ajaxView01() {
        return "/ajaxView/ajax01";
    }

    @GetMapping("/ajax-view02")
    public String ajaxView02() {
        return "/ajaxView/ajax02";
    }

    @GetMapping("/ajax-view03")
    public String ajaxView03() {
        return "/ajaxView/ajax03";
    }

    @GetMapping("/ajax-view04")
    public String ajaxView04() {
        return "/ajaxView/ajax04";
    }

    @GetMapping("/ajax-view05")
    public String ajaxView05() {
        return "/ajaxView/ajax05";
    }

    @GetMapping("/ajax-view06")
    public String ajaxView06() {
        return "/ajaxView/ajax06";
    }

    @GetMapping("/ajax-view07")
    public String ajaxView07() {
        return "/ajaxView/ajax07";
    }

    @GetMapping("/ajax-view08")
    public String ajaxView08() {
        return "/ajaxView/ajax08";
    }

    @GetMapping("/ajax-view09")
    public String ajaxView09() {
        return "/ajaxView/ajax09";
    }

    @GetMapping("/ajax-view10")
    public String ajaxView10() {
        return "/ajaxView/ajax10";
    }

    @GetMapping("/ajax-view11")
    public String ajaxView11() {
        return "/ajaxView/ajax11";
    }
}
