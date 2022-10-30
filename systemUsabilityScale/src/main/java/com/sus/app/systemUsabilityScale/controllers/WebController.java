package com.sus.app.systemUsabilityScale.controllers;

import com.sus.app.systemUsabilityScale.models.Scale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/register")
    public String showForm(Model model) {
        Scale scale = new Scale();
        model.addAttribute("scale", scale);

        List<String> listAgreement = Arrays.asList("1 - strongly disagree", "2", "3", "4", "5 - strongly agree");
        model.addAttribute("listAgreement", listAgreement);

        return "scale_form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("scale") Scale scale) {
        System.out.println(scale);
        return "register_success";
    }

}
