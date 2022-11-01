package com.sus.app.systemUsabilityScale.controllers;


import com.sus.app.systemUsabilityScale.models.Scale;
import com.sus.app.systemUsabilityScale.repositories.ScaleRepository;
import com.sus.app.systemUsabilityScale.services.ScaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class FormController {
    @Autowired
    ScaleRepository scaleRepository;
/*    @Autowired
    ScoreRepository scoreRepository;*/
    @Autowired
    ScaleService scaleService;

    @GetMapping("/")
    public String redirectHome() {
        return "redirect:/form";
    }
    @GetMapping("/form")
    public String showForm(Model model, HttpSession httpSession) {

        Scale scale = new Scale();
        model.addAttribute("scale", scale);
        return "form";
    }
    @PostMapping("/form")
    public String postScore(@ModelAttribute("scale") Scale scale, Model model) {
        model.addAttribute("result", scaleService.computeScore(scale));
        scale.setScore(scaleService.computeScore(scale));
        scaleRepository.saveAndFlush(scale);
        return "globals";
    }
    @GetMapping("/globals")
    public String showGlobals() {
        return "globals";
    }

    @GetMapping("/form/{id}")
    @ResponseBody
    public Optional<Scale> getFoos(@RequestParam() Scale scale) {
        return scaleRepository.findById(scale.getId());
    }

/*    @GetMapping("/scores")
    public List<Object[]> getAllScores(@RequestParam Scale scale) {
        return scaleRepository.findByBlaBla(1);
    }*/


/*    @GetMapping("/scores")
    public List<AllScores> getScores() {
        return scoreRepository.findAllScores();
    }*/



/*    @GetMapping("/globals")
    public ResponseEntity<List<Scale2>> showGlobals(@RequestParam() double averageScore) {
        List<Scale2> scales = new ArrayList<>();
        scaleRepository.findAll().forEach(scales.score);
        return "globals";
    }*/

/*    @GetMapping("/allScores")
    public ResponseEntity<List<String>> getAllScales(@RequestParam(required = false) List<Double>) {
        List<Double> scores = new ArrayList<>();
        scaleRepository.findScores();

        return new ResponseEntity<>(scores, HttpStatus.OK);
    }*/



/*    @GetMapping("/scores")
    @ResponseBody
    public List<Scale2> getScores(Model model, @RequestParam Double score) {
        List<Employee> result = new ArrayList<>();
        employeeRepository.findByName(employee.getName()).forEach(e -> result.add(e));
        return scores;
    }*/


/*    @GetMapping("/scores")
    public String getScores(Model model, Pageable pageable) {
        model.addAttribute("scores", scaleRepository.findByScore(pageable));
        return "scores";
    }*/

}
