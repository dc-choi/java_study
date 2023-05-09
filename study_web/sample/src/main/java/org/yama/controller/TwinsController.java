package org.yama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.yama.model.Twins;
import org.yama.service.TwinsService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/roster")
public class TwinsController {
    @Autowired
    private TwinsService twinsService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        int total = twinsService.total();
        List<Twins> list = twinsService.list();

        model.addAttribute("total", total);
        model.addAttribute("list", list);
        return "roster";
    }
}
