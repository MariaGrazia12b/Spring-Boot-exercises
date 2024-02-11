package com.example.deploy01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {
    @GetMapping
    public String getDevName() {
        return "devName: MariaGrazia";
    }
}
