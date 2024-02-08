package com.example.customQueries01.services;

import com.example.customQueries01.entities.Flight;
import com.example.customQueries01.repositories.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FlightService {
    @Autowired
    FlightRepo flightRepo;

    private static final int numFlights = 50;
    public List<Flight> allFlights() {
        return flightRepo.findAll();
    }
    public void provisionFlight() {
        Random random = new Random();
        for (int i = 0; i < numFlights; i ++) {
            Flight flight = new Flight();
            flight.setDescription("Flight details");
            flight.setFromAirport(generateRandomString(random));
            flightRepo.save(flight);
        }
    }

    private String generateRandomString(Random random) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}
