package com.example.consumer;

import com.example.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    public static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "FirstJsonTopic", groupId ="myGroup" )
    public  void consumeMessage(User message)
    {
        LOGGER.info(String.format("message received-->%s",message.toString()));
    }
}
