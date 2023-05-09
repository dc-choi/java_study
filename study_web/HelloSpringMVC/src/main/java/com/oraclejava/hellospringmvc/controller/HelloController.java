package com.oraclejava.hellospringmvc.controller;

import com.oraclejava.hellospringmvc.model.Login;
import com.oraclejava.hellospringmvc.model.Member;
import com.oraclejava.hellospringmvc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value="/")
public class HelloController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView welcome() {
        return new ModelAndView("welcomePage",
                "welcomeMessage", "안녕하세요!");

    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "welcomePage";
    }

    @RequestMapping(value="/loginSuccess", method = RequestMethod.POST)
    public ModelAndView loginSuccess(
            @Valid @ModelAttribute("login") Login login,
            BindingResult result,
            HttpSession session) {
        if (result.hasErrors()) {
            return new ModelAndView("login");
        }

        ModelAndView modelAndView = new ModelAndView("successPage");

        Member member = memberService.login(login.getId(), login.getPass());
        if (member != null) {
            //로그인 성공!
            session.setAttribute("id", login.getId());
            modelAndView.addObject("member", member);
            return modelAndView;
        } else {
            // 로그인 실패!
            modelAndView = new ModelAndView("notFound");
        }

        return modelAndView;
    }
}
