package com.example.Esercizio12.Controller;

import com.example.Esercizio12.Entities.UserEntity;
import com.example.Esercizio12.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userRepo.save(user);
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userRepo.findById(id).get();
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity userDetails) {
        UserEntity user = userRepo.findById(id).get();

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());

        return userRepo.save(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
        return "User deleted successfully!";
    }
}
