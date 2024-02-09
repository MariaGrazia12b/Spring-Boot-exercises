package com.example.customQueries01.controllers;

import com.example.customQueries01.entities.Flight;
import com.example.customQueries01.repositories.FlightRepo;
import com.example.customQueries01.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightService flightService;
    @GetMapping("getAll")
    public List<Flight> getAllFlights() {
        return flightService.allFlights();
    }
    @GetMapping("/provision")
    public void provisionFlights() {
        flightService.provisionFlight();
    }

}
