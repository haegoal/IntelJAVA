package com.icia.member.controller;

import com.icia.member.dto.MemberDTO;
import com.icia.member.repository.MemberRepository;
import com.icia.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginEmail");
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "memberList";
    }

    @GetMapping("/save")
    public String save(){
        return "memberSave";
    }

    @GetMapping("/login")
    public String login(){
        return "memberLogin";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id,Model model){
        MemberDTO memberDTO = memberService.findId(id);
        model.addAttribute("member", memberDTO);
        return "memberUpdate";
    }

    @PostMapping("/member-login")
    public String login(@RequestParam("memberEmail") String memberEmail, @ModelAttribute MemberDTO memberDTO, HttpSession session) {
        boolean result = memberService.findEmail(memberEmail);
        if (result) {
            memberDTO = memberService.login(memberDTO);
            if (memberDTO != null) {
                session.setAttribute("loginEmail", memberDTO.getMemberEmail());
                return "memberMain";
            } else {
                return "memberLogin";
            }
        }else{
            return "memberLogin";
        }
    }

    @PostMapping("/member-save")
    public String save(@ModelAttribute MemberDTO memberDTO){
        memberService.save(memberDTO);
        return "memberLogin";
    }

    @PostMapping("/member-ajax")
    public ResponseEntity search(@RequestParam("id") Long id){
        MemberDTO memberDTO = memberService.findId(id);
        if(memberDTO!=null){
            return new ResponseEntity<>(memberDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/member-update")
    public String update(@ModelAttribute MemberDTO memberDTO) {
        memberService.update(memberDTO);
        return "memberList";
    }
}
