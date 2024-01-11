package com.example.Esercizio3;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class Esercizio3Controller {
    @GetMapping("/name")
    public String name (@RequestParam String name) {
        return "Nome: " + name;
    }

    @PostMapping("/reverse-nome")
    public String reverseName (@RequestBody String name) {
        StringBuilder reversedName = new StringBuilder(name).reverse();
        return "Nome al contrario: " + reversedName.toString();
    }
}
