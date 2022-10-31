package com.sus.app.systemUsabilityScale.controllers;


import com.sus.app.systemUsabilityScale.models.Scale2;
import com.sus.app.systemUsabilityScale.models.Score;
import com.sus.app.systemUsabilityScale.repositories.Scale2Repository;
import com.sus.app.systemUsabilityScale.repositories.ScaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

@Controller
public class FormController {

    @Autowired
    Scale2Repository scaleRepository;

    @GetMapping("/form")
    public String getForm(Model model) {
        Scale2 scale = new Scale2();
        model.addAttribute("Scale", scale);
        return "form";
    }

    @PostMapping("/formPost")
    public String postScore(@ModelAttribute("scale") Scale2 scale, Model model) {
        model.addAttribute("result", scale);
        scaleRepository.saveAndFlush(scale);
        return "form";
    }
}
