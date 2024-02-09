package com.example.customQueries01.repositories;

import com.example.customQueries01.entities.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<Flight,Long> {
    @Query(value = "SELECT * FROM Flight ", nativeQuery = true)
    List<Flight> findAllFlights ();
}
