package com.example.Esercizio12.Repository;

import com.example.Esercizio12.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
}
