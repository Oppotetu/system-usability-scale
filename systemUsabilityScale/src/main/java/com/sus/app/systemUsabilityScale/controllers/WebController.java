package com.sus.app.systemUsabilityScale.controllers;

import com.sus.app.systemUsabilityScale.models.Scale;
import com.sus.app.systemUsabilityScale.repositories.ScaleRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class WebController {

    @Autowired
    private ScaleRepository scaleRepository;

    @GetMapping("scales")
    public List<Scale> getScale() {
        return this.scaleRepository.findAll();
    }

    @GetMapping("scales/average")
    public float getAverageScore() {

        return this.scaleRepository.findAverageScore();
    }
}
