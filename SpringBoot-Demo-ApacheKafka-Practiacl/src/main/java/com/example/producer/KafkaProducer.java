package com.example.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    public static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message)
    {
        LOGGER.info("message pass %s",message);
        kafkaTemplate.send("FirstTopic",message);
    }
}
