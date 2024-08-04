package com.example.kafkasecondexample.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {
    Logger logger=LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "first",groupId = "demo")

    public void messageConsume(String mesaage)
    {
        logger.info("consumer the message from kafka");
    }
}
