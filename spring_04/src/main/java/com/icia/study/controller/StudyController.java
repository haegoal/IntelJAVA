package com.icia.study.controller;

import com.icia.study.dto.StudyDTO;
import com.icia.study.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudyController {
    @Autowired
    private StudyService studyService;

    @GetMapping("/req1")
    public String req1(){
        studyService.req1();
        return "index";
    }

    @GetMapping("/req2")
    public String req2(@RequestParam("q1") String q1, @RequestParam("q2") String q2){
        studyService.req2(q1, q2);
        return "index";
    }


    @GetMapping("/req3")
    public String req3(@ModelAttribute StudyDTO studyDTO){
        studyService.req3(studyDTO);
        return "index";
    }

    @GetMapping("/req4")
    public String req4(Model model){
        StudyDTO studyDTO = studyService.req4();
        model.addAttribute("study", studyDTO);
        return "req4";
    }

    @GetMapping("/req5")
    public String req5(Model model){
        List<StudyDTO> studyDTOList = studyService.req5();
        model.addAttribute("list", studyDTOList);
        return "req5";
    }

}

