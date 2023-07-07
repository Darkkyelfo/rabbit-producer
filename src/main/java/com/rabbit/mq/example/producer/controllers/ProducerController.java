package com.rabbit.mq.example.producer.controllers;

import com.rabbit.mq.example.producer.config.RabbitMqConstants;
import com.rabbit.mq.example.producer.model.Message;
import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class ProducerController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    RabbitMqConstants rabbitMqConstants;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody Message message) {
        log.info("message <{}>", message);
        rabbitTemplate.convertAndSend(rabbitMqConstants.exchange,rabbitMqConstants.routingkey,message);
        return ResponseEntity.ok("MESSAGE SEND!");
    }
}
