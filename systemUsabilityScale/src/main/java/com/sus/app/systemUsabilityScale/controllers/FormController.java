package com.sus.app.systemUsabilityScale.controllers;


import com.sus.app.systemUsabilityScale.models.Scale2;
import com.sus.app.systemUsabilityScale.models.Score;
import com.sus.app.systemUsabilityScale.repositories.Scale2Repository;
import com.sus.app.systemUsabilityScale.repositories.ScaleRepository;
import com.sus.app.systemUsabilityScale.services.ScaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FormController {
    @Autowired
    Scale2Repository scaleRepository;
    @Autowired
    ScaleService scaleService;

    @GetMapping("/")
    public String redirectHome() {
        return "redirect:/form";
    }

    @GetMapping("/form")
    public String showForm(Model model, HttpSession httpSession) {

        Scale2 scale2 = new Scale2();
        model.addAttribute("scale2", scale2);
        return "form";
    }

    @PostMapping("/form")
    public String postScore(@ModelAttribute("scale2") Scale2 scale2, Model model) {
        model.addAttribute("result", scaleService.computeScore(scale2));
        scale2.setScore(scaleService.computeScore(scale2));
        scaleRepository.saveAndFlush(scale2);
        return "globals";
    }

/*    @GetMapping("/globals")
    public String showGlobals() {
        return "globals";
    }*/

/*    @GetMapping("/globals")
    public ResponseEntity<List<Scale2>> showGlobals(@RequestParam() double averageScore) {
        List<Scale2> scales = new ArrayList<>();
        scaleRepository.findAll().forEach(scales.score);
        return "globals";
    }*/

    @GetMapping("/allScores")
    public ResponseEntity<List<String>> getAllScales(@RequestParam(required = false) List<Double>) {
        List<Double> scores = new ArrayList<>();
        

        return new ResponseEntity<>(scores, HttpStatus.OK);
    }
}
