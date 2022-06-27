package com.nasa.msmarsrobots.controller;

import com.nasa.msmarsrobots.model.service.RoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mars")
public class RoverController {

    @Autowired RoverService service;

    @PostMapping("{movement}")
    public ResponseEntity roverMovement(@PathVariable String movement){
        return new ResponseEntity<>(service.movementRover(movement).toString(), HttpStatus.OK);
    }
}
