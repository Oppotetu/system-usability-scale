package com.sus.app.systemUsabilityScale.controllers;

import com.sus.app.systemUsabilityScale.models.Scale;
import com.sus.app.systemUsabilityScale.repositories.ScaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ScaleController {

    @Autowired
    ScaleRepository scaleRepository;

    @GetMapping("/scales")
    public ResponseEntity<List<Scale>> getAllScales(@RequestParam(required = false) int score) {
        try {
            List<Scale> scales = new ArrayList<>();
            scaleRepository.findAll().forEach(scales::add);
            if (scales.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(scales, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/scales/{id}")
    public ResponseEntity<Scale> getScalesById(@PathVariable("id") long id) {
        Optional<Scale> scaleData = scaleRepository.findById(id);

        if (scaleData.isPresent()) {
            return new ResponseEntity<>(scaleData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/scales")
    public ResponseEntity<Scale> createScale(@RequestBody Scale scale) {
        try {
            Scale _scale = scaleRepository
                    .save(new Scale(scale.getQ1(), scale.getQ2()));
            return new ResponseEntity<>(_scale, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/scales/{id}")
    public ResponseEntity<Scale> updateScale(@PathVariable("id") long id, @RequestBody Scale scale) {
        Optional<Scale> scaleData = scaleRepository.findById(id);

        if (scaleData.isPresent()) {
            Scale _scale = scaleData.get();
            _scale.setQ1(scale.getQ1());
            _scale.setQ2(scale.getQ2());
/*
            _scale.setSum(_scale.getQ1() + _scale.getQ2());
*/
            return new ResponseEntity<>(scaleRepository.save(_scale), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/scales/{id}")
    public ResponseEntity<HttpStatus> deleteScale(@PathVariable("id") long id) {
        try {
            scaleRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
