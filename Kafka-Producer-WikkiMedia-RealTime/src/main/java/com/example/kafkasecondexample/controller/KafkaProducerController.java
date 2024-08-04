package com.example.kafkasecondexample.controller;

import com.example.kafkasecondexample.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class KafkaProducerController {
    @Autowired
    public KafkaMessagePublisher messagePublisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?>  publishMessage(@PathVariable String message)
    {
        try {
            messagePublisher.sendMessageToTopic(message);
           return ResponseEntity.ok("sent messahe");
        }catch (Exception ex)
        {
            return  ResponseEntity.ok(ex.getMessage());
        }
    }
}

//http://localhost:8080/producer/publish/hello