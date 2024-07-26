package com.example.kafkamessagesender;

import com.example.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaMessageSenderRestAPI {
    @Autowired
    public KafkaProducer producer;

    @GetMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam("message")String message)
    {
        producer.sendMessage(message);
        return ResponseEntity.ok("message has been sent successfully");
    }
}

//http://localhost:8080/api/v1/kafka/publish?message=hello