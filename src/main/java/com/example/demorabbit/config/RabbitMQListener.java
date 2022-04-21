package com.example.demorabbit.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class RabbitMQListener {

    Logger logger = LoggerFactory.getLogger(RabbitMQListener.class);

    @RabbitListener(queues = "MyQueue")
    public void processMyQueue(String message){

        logger.info("Message is: " + message);
    }

    @RabbitListener(queues = "MyQueue")
    public void processMyQueue2(String message){

        logger.info("Message 2 is: " + message);
    }
}
