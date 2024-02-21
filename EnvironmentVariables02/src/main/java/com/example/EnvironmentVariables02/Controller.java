package com.example.EnvironmentVariables02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Controller {
    @Autowired
    private Environment environment;

    @GetMapping("/hello")
    public String hello() {
        return environment.getProperty("welcomeMsg");
    }
}
