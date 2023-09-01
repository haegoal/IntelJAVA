package com.icia.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 컨트롤러클래스로쓰겠다 @= 실행시 우선

public class HomeController {

    // 프로젝트 시작시 index.jsp를 브라우저에 출력
    @GetMapping("/") // 주소실행
    public String index(){
        return "index";
    }
}
