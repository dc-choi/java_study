package com.oraclejava.hellospringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequestMapping(value="/")
public class NowController {

    @RequestMapping(value = "/now")
    public ModelAndView showNow() {
        LocalDate now = LocalDate.now();
        LocalTime time = LocalTime.now();
        return new ModelAndView("now", "now",
                now + " " + time.toString().substring(0,8));
    }
}
