package com.example.customQueries02.controllers;

import com.example.customQueries02.entities.Flight;
import com.example.customQueries02.entities.Status;
import com.example.customQueries02.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightService flightService;
    @GetMapping("/provision")
    public void provisionFlights(@RequestParam(name = "n", defaultValue = "100") int n) {
        flightService.provisionFlight(n);
    }
    @GetMapping("/all")
    public List<Flight> getAllFlights() {
        return flightService.allFlights();
    }

    @GetMapping("/paginated")
    public List<Flight> getAllFlights(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {
        return flightService.getAllFlightsPaginated(page, size);
    }

    @GetMapping("/ontime")
    public List<Flight> getOnTimeFlights() {
        return flightService.getOnTimeFlights();
    }

    @GetMapping("/status")
    public List<Flight> getFlightsByStatus(@RequestParam(name = "p1") Status status1,
                                           @RequestParam(name = "p2") Status status2) {
        return flightService.getFlightsByStatus(status1, status2);
    }
}
