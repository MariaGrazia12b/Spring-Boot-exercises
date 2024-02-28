package com.example.loggingLorenzo.controllers;

import com.example.loggingLorenzo.services.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    Service service;
    Logger logger = LoggerFactory.getLogger(Controller.class);
    @GetMapping("/debug")
    public void getDebug() {
        logger.debug("debug");
    }
    @GetMapping("/greetings")
    public String greetings() {
        logger.info("Starting greeting");
        return service.doGreeting(5);

    }
    @GetMapping("/info")
    public void getInfo() {
        logger.info("info");

    }
    @GetMapping("/warning")
    public void getWarning() {logger.warn("warning");
    }
    @GetMapping("/errors")
    public void getError() {
        Error error = new Error("This is the error");
        logger.error("error", error);

    }
}
