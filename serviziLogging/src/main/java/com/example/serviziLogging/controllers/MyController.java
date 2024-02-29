package com.example.serviziLogging.controllers;

import com.example.serviziLogging.sevices.MyService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
@RequiredArgsConstructor
public class MyController {
    private final MyService myService;

    Logger logger = LoggerFactory.getLogger(MyController.class);

    @GetMapping
    public String hello() {
        logger.info("Hello users");
        return "Hello users";
    }

    @GetMapping("/exp")
    public double doCalculations() {
        return myService.doCalculation();
    }

    @GetMapping("/get-errors")
    public void getErrors() throws Exception {
        logger.error("An error has occurred");
        throw new Exception("Custom exception");
    }

}
