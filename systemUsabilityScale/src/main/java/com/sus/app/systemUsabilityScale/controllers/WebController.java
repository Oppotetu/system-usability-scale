package com.sus.app.systemUsabilityScale.controllers;

import com.sus.app.systemUsabilityScale.models.Scale;
import com.sus.app.systemUsabilityScale.repositories.ScaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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

/*    @GetMapping("scales/time")
    public List<Scale> getTime() throws ParseException {
        List<Scale> result = this.scaleRepository.findByDate(
                new SimpleDateFormat("yyyy-MM-dd HH:mm").
                        parse("2022-11-01 10:10"));
        return result;
    }*/
}
