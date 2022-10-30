package com.sus.app.systemUsabilityScale.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class WebController {

    @RequestMapping(value = "/scales")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/dates")
    public String getInfo(Model model) {
        model.addAttribute("standardDate", new Date());
        return "dates.html";
    }
}
