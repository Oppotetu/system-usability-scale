package com.sus.app.systemUsabilityScale.controllers;


import com.sus.app.systemUsabilityScale.models.Scale;
import com.sus.app.systemUsabilityScale.repositories.ScaleRepository;
import com.sus.app.systemUsabilityScale.services.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


@Controller
@RequestMapping
public class FormController {
    @Autowired
    ScaleRepository scaleRepository;

    @Autowired
    ComputeService computeService;

    private final Set<String> sessionIds = Collections.synchronizedSet(new HashSet<>());

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

    @PostMapping("/form")
    public String postScore(@ModelAttribute("scale") Scale scale, Model model, HttpSession session) {
        model.addAttribute("result", computeService.computeScore(scale));

        if (session.getAttribute("submit") == null) {
            scale.setScore(computeService.computeScore(scale));
            scale.setSqlTimestamp(Date.from(Instant.now()));
            scaleRepository.saveAndFlush(scale);
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
        model.addAttribute("hourly", scaleRepository.findHourlyScore()).toString();
        model.addAttribute("daily", scaleRepository.findDailyScore()).toString();
        model.addAttribute("weekly", scaleRepository.findWeeklyScore()).toString();
        model.addAttribute("monthly", scaleRepository.findMonthlyScore()).toString();
        return "globals";
    }

    private Object getRequestCount(HttpSession session) {
        Integer requestCount = (Integer) session.getAttribute("requestCount");
        requestCount = requestCount != null ? requestCount : 0;
        requestCount++;
        session.setAttribute("requestCount", requestCount);
        return requestCount;
    }
}
