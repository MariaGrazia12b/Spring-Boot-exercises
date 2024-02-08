package com.example.customQueries02.repositories;

import com.example.customQueries02.entities.Flight;

import com.example.customQueries02.entities.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface FlightRepo extends JpaRepository<Flight,Long> {
    @Query (value = "SELECT * FROM Flight ", nativeQuery = true)
    Page<Flight> findAllPaged (Pageable pageable);

    List<Flight> findByStatus(Status status);

    @Query("SELECT f FROM Flight f WHERE f.status = ?1 OR f.status = ?2")
    List<Flight> findByStatusIn(Status status1, Status status2);


}
