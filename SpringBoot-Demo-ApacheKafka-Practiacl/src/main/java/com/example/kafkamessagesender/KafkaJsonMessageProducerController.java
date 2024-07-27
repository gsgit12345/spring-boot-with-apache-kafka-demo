package com.example.kafkamessagesender;


import com.example.pojo.User;
import com.example.producer.KafkaJsonProducer;
import com.example.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaJsonMessageProducerController {

    @Autowired
    public KafkaJsonProducer producer;

    @PostMapping("/publish")
public ResponseEntity<String> publishJsonMessage(@RequestBody User user)
{
    producer.sendMessage(user);

    return ResponseEntity.ok("json message has been sent");
}
// http://localhost:8080/api/v1/kafka/publish
}
