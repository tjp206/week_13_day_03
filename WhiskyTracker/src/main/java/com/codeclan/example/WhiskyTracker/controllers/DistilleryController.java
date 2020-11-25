package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleries() {
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/{id}")
    public ResponseEntity getDistillery(@PathVariable Long id) {
        return new ResponseEntity<>(distilleryRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/distilleries")
    public ResponseEntity<Distillery> postRaid(@RequestBody Distillery distillery) {
        distilleryRepository.save(distillery);
        return new ResponseEntity<>(distillery, HttpStatus.CREATED);
    }

    @GetMapping(value = "/distilleries/whiskies")
    public ResponseEntity<List<Distillery>> findDistilleriesThatHaveWhiskiesNamedQueryString(@RequestParam(name="region") String name) {
        return new ResponseEntity<>(distilleryRepository.findAllDistilleriesByRegion(name), HttpStatus.OK);
    }

}
