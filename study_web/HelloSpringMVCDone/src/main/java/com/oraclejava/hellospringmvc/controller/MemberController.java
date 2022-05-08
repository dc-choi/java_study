package com.oraclejava.hellospringmvc.controller;

import com.oraclejava.hellospringmvc.model.Member;
import com.oraclejava.hellospringmvc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MemberController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, "birth",
                new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    private MemberService memberService;

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("member", new Member());
        return "register";  // register.jsp
    }

    @RequestMapping(value="/registerSuccess", method = RequestMethod.POST)
    public String registerSuccess(@Valid @ModelAttribute("member") Member member,
                                  BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        memberService.addMember(member);
        return "registerSuccess";
    }


    @RequestMapping(value="/listMembers", method = RequestMethod.GET)
    public ModelAndView memberInfo() {
        return new ModelAndView("memberlistPage",
                "memberlist", memberService.getAllMemberInfo());
    }
}
