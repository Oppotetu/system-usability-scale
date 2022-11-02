package com.sus.app.systemUsabilityScale.controllers;


import com.jayway.jsonpath.internal.function.numeric.Average;
import com.sus.app.systemUsabilityScale.models.Scale;
import com.sus.app.systemUsabilityScale.repositories.ScaleRepository;
import com.sus.app.systemUsabilityScale.services.ComputeService;
import com.sus.app.systemUsabilityScale.services.ScaleService;
import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.IContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.*;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Controller
@RequestMapping
public class FormController {
    @Autowired
    ScaleRepository scaleRepository;
    @Autowired
    ScaleService scaleService;
    @Autowired
    ComputeService computeService;

    private final Set<String> sessionIds = Collections.synchronizedSet(new HashSet<>());
    private final Set<Double> ScaleScores = Collections.synchronizedSet(new HashSet<>());

    @GetMapping("/form")
    public String showRegistrationForm(Model model, HttpSession session) {
        this.sessionIds.add(session.getId());
        model.addAttribute("sessionType", session.getClass().getName());
        model.addAttribute("sessionCount", this.sessionIds.size());
        model.addAttribute("requestCount", getRequestCount(session));
        Scale scale = new Scale();
        model.addAttribute("scale", scale);
        return "form";
    }
/*
        System.out.println(session.getId());
        System.out.println(model.getAttribute("result"));
        System.out.println(session.getAttribute("sessionType"));
        System.out.println(session.getAttribute("sessionCount"));
        System.out.println(session.getAttribute("requestCount"));
*/

    @PostMapping("/form")
    public String postScore(@ModelAttribute("scale") Scale scale, Model model, HttpSession session) {
        model.addAttribute("result", computeService.computeScore(scale));

        if (session.getAttribute("submit") == null) {
            scaleRepository.saveAndFlush(scale);
            scale.setScore(computeService.computeScore(scale));
            this.ScaleScores.add(scale.getScore());
            session.setAttribute("submit", true);
            return "form";
        }

        return "already";
    }

    @GetMapping("globals")
    public String getAverage(Model model, HttpSession session) {
        session.invalidate();
        model.addAttribute("count", scaleRepository.findScoreCount()).toString();
        model.addAttribute("average", scaleRepository.findAverageScore()).toString();
        model.addAttribute("highest", scaleRepository.findHighestScore()).toString();
        model.addAttribute("lowest", scaleRepository.findLowestScore()).toString();
        return "globals";
    }

    private Object getRequestCount(HttpSession session) {
        Integer requestCount = (Integer) session.getAttribute("requestCount");
        requestCount = requestCount != null ? requestCount : 0;
        requestCount++;
        session.setAttribute("requestCount", requestCount);
        return requestCount;
    }


/*    @GetMapping("/scales")
    @ResponseBody
    public Optional<Scale> getFoos(@RequestParam() Scale scale) {
        return scaleRepository.findById(scale.getId());
    }*/

/*
    @GetMapping("/scales")
    List<Scale> all() {
        return scaleRepository.findAll();
    }

    @GetMapping("/scales/{id}")
    EntityModel<Scale> one(@PathVariable Long id) {

        Scale scale = scaleRepository.findById(id) //
                .orElseThrow(() -> new ScaleNotFoundException(id));

        return EntityModel.of(scale, //
                linkTo(methodOn(FormController.class).one(id)).withSelfRel(),
                linkTo(methodOn(FormController.class).all()).withRel("scales"));
    }
*/

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
