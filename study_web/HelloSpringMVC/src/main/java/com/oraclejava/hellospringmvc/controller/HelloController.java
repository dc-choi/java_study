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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class HelloController {
    @Autowired
    private MemberService memberService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView welcome() {
        return new ModelAndView(
                "welcomePage",
                "welcomeMessage",
                "좋은 휴일 되세요~1111"
        );
    }

    @RequestMapping(value = "loginPage", method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("login", new Login());
        return "loginPage";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(
            @Validated @ModelAttribute("login") Login login,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "loginPage";
        }

        Member member = memberService.login(login.getId(), login.getPassword());
        System.out.println(member);
        return "redirect:/";
    }
}
