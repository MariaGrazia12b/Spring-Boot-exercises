package com.example.Esercizio9.Repository;

import com.example.Esercizio9.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Repo extends JpaRepository<Car, Long> {
}
