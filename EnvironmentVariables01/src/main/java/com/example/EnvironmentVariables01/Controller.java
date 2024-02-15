package com.example.EnvironmentVariables01;

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

    @GetMapping("/nameCode")
    public String getNameCode() {
        String devName = environment.getProperty("devName");
        String auth = environment.getProperty("authCode");

        return "Dev name = " + devName + " AuthCode = " + auth;
    }
}
