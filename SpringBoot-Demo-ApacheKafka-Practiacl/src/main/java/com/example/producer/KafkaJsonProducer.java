package com.example.producer;

import com.example.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaJsonProducer.class);

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
public void sendMessage(User data)
{
    LOGGER.info(String.format("message sent with json payload-->%s",data.toString()));
    Message<User> message= MessageBuilder.withPayload(data).
            setHeader(KafkaHeaders.TOPIC,"FirstJsonTopic").build();


    kafkaTemplate.send(message);
}
}
