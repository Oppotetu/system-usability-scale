package com.sus.app.systemUsabilityScale.controllers;


import com.sus.app.systemUsabilityScale.models.Scale2;
import com.sus.app.systemUsabilityScale.models.Score;
import com.sus.app.systemUsabilityScale.repositories.Scale2Repository;
import com.sus.app.systemUsabilityScale.repositories.ScaleRepository;
import com.sus.app.systemUsabilityScale.services.ScaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

import javax.swing.*;

@Controller
public class FormController {

    @Autowired
    Scale2Repository scaleRepository;
    @Autowired
    ScaleService scaleService;

/*    @GetMapping("/form")
    public String getForm(Model model) {
*//*
        Scale2 scale = new Scale2();
        model.addAttribute("Scale", scale);
*//*
        return "form";
    }*/

/*    @GetMapping("/form")
    public ModelAndView showForm(Model model, InputMap inputMap) {
*//*
        Scale2 scale = new Scale2();
*//*

*//*
        List<String> listAgreement = Arrays.asList("1 - strongly disagree", "2", "3", "4", "5 - strongly agree");
        model.addAttribute("listAgreement", listAgreement);
*//*

        return new ModelAndView("form");
    }*/

    @GetMapping("/form")
    public String showForm(Model model) {
        Scale2 scale2 = new Scale2();
        model.addAttribute("scale2", scale2);
        return "form";
    }

    @PostMapping("/form")
    public String postScore(@ModelAttribute("scale2") Scale2 scale2, Model model) {
        model.addAttribute("result", scaleService.computeScore(scale2));
        scale2.setScore(scaleService.computeScore(scale2));
        scaleRepository.saveAndFlush(scale2);
        return "form";
    }
}
