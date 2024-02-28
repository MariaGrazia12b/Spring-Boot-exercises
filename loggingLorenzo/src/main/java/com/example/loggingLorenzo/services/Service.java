package com.example.loggingLorenzo.services;

import com.example.loggingLorenzo.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@org.springframework.stereotype.Service
public class Service {
    Logger logger = LoggerFactory.getLogger(Service.class);
    public String doGreeting(int numOgGreetings){
        try {
            logger.info("Starting greeting: " + numOgGreetings + "User:" + new User("Maria", "Rossi"));
            //logica
            return "Greetings";
        }finally {
            logger.info("Ending greeting");
        }

    }
}
