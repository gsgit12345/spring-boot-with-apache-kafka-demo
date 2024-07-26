package com.example.consumer;

import org.apache.kafka.common.internals.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    public static final Logger LOGGER= LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "FirstTopic", groupId ="myGroup" )
    public  void consumeMessage(String message)
    {
     LOGGER.info(String.format("message received-->%s",message));
    }
}
