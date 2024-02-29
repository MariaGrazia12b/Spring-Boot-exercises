package com.example.serviziLogging.sevices;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyService {
    @Autowired
    private Environment environment;
    Logger logger = LoggerFactory.getLogger(MyService.class);

    public double doCalculation() {
        int value1 = Integer.valueOf(environment.getProperty("value1"));
        int value2 = Integer.valueOf(environment.getProperty("value2"));
        logger.debug("Starting calculations");
        logger.debug("Calculating the result of {}^{}", value1, value2);
        double result = Math.pow(value1, value2);
        logger.debug("The result is: {}", result);
        return result;
    }
}
