package com.icia.demo.controller;

import com.icia.demo.dto.DemoDTO;
import com.icia.demo.service.DemoDBService;
import com.icia.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DemoDBController {

    @Autowired
    private DemoDBService demoDBService;

    @GetMapping("/demodb1")
    public String demodb1(){
        return "demodb1";
    }

    @GetMapping("/demodb2")
    public String demodb2(Model model){
        List<DemoDTO> demoDTOList = demoDBService.list();
        System.out.println("demoDTOList = " + demoDTOList);
        model.addAttribute("demolist", demoDTOList);
        return "demodb2";
    }

    @GetMapping("/find")
    public String find(@RequestParam("id") Long id,Model model){
        DemoDTO demoDTO = demoDBService.find(id);
        model.addAttribute("demo", demoDTO);
        return "demodb3";
    }

    @PostMapping("/reqdb1")
    public String reqdb1(@ModelAttribute DemoDTO demoDTO){
        demoDBService.reqdb1(demoDTO);
        return "index";
    }

    @PostMapping("/req4")
    public String req4(@RequestParam("id") Long id, Model model){
        demoDBService.delete(id);
        List<DemoDTO> demoDTOList = demoDBService.list();
        model.addAttribute("demolist", demoDTOList);
        return "demodb2";
    }
    
    @PostMapping("/update")
    public String req5(@ModelAttribute DemoDTO demoDTO,Model model){
        System.out.println("demoDTO = " + demoDTO);
        demoDBService.update(demoDTO);
        List<DemoDTO> demoDTOList = demoDBService.list();
        model.addAttribute("demolist", demoDTOList);
        return "demodb2";
    }
}
