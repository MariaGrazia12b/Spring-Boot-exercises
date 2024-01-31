package com.example.Esercizio10.Repository;

import com.example.Esercizio10.Entities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PLRepository extends JpaRepository<ProgrammingLanguage, Long> {

}
