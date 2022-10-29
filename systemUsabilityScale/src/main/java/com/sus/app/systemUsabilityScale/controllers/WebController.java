package com.sus.app.systemUsabilityScale.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping(value = "/scales")
    public String index() {
        return "index";
    }
}
