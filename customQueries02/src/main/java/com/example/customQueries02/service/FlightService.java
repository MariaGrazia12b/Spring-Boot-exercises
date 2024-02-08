package com.example.customQueries02.service;

import com.example.customQueries02.entities.Flight;
import com.example.customQueries02.entities.Status;
import com.example.customQueries02.repositories.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FlightService {
    @Autowired
    FlightRepo flightRepo;

    public List<Flight> allFlights() {
        return flightRepo.findAll();
    }
    public void provisionFlight(int n) {
        Random random = new Random();
        for (int i = 0; i < n; i ++) {
            Flight flight = new Flight();
            flight.setDescription("Flight details");
            flight.setFromAirport(generateRandomString(random));
            flight.setToAirport(generateRandomString(random));
            flight.setStatus(Status.values()[random.nextInt(Status.values().length)]);
            flightRepo.save(flight);
        }
    }

    public List<Flight> getAllFlightsPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("from_airport").ascending());
        return flightRepo.findAllPaged(pageable).getContent();
    }

    public List<Flight> getOnTimeFlights() {
        return flightRepo.findByStatus(Status.ONTIME);
    }

    public List<Flight> getFlightsByStatus(Status status1, Status status2) {
        return flightRepo.findByStatusIn(status1, status2);
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
