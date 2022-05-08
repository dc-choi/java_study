package com.oraclejava.hellospringmvc.controller;

import com.oraclejava.hellospringmvc.model.Login;
import com.oraclejava.hellospringmvc.model.Member;
import com.oraclejava.hellospringmvc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "listMembers", method = RequestMethod.GET)
    public ModelAndView listMember() {
        return new ModelAndView(
            "memberListPage",
            "memberList",
            memberService.listMember()
        );
    }

    @RequestMapping(value = "addMember", method = RequestMethod.GET)
    public String addMember(Model model) {
        model.addAttribute("member", new Member());
        return "addMemberPage";
    }

    @RequestMapping(value = "addMemberAction", method = RequestMethod.POST)
    public String addMemberAction(
            @Validated @ModelAttribute("member") Member member,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "addMemberPage";
        }

        memberService.addMember(member);
        return "redirect:/listMembers";
    }
}
