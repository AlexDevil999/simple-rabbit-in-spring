package com.example.demorabbit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class SimpleController {
    Logger logger = LoggerFactory.getLogger(SimpleController.class);

   private final AmqpTemplate amqpTemplate;

   @Autowired
    public SimpleController(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @PostMapping("/emit")
    public ResponseEntity<String> emit(@RequestBody String message){
       logger.info("Emit to my queue");

        for (int i = 0; i < 10; i++) {

            amqpTemplate.convertAndSend("MyQueue", ThreadLocalRandom.current().nextInt());

        }
       return ResponseEntity.ok("OK!");
    }
}
