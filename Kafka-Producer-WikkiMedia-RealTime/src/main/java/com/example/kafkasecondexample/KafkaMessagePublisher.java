package com.example.kafkasecondexample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {
    @Autowired
    KafkaTemplate<String,Object>  kafkaTemplate;
    public void  sendMessageToTopic(String message)
    {
        CompletableFuture<SendResult<String,Object>>  sendMessage=kafkaTemplate.send("first",message);
        sendMessage.whenComplete((result,ex)->
        {
            if(ex==null)
            {
                System.out.println("Sent message["+message+"]"+"with offset=["+result.getRecordMetadata().offset()+"]");
            }else {
                System.out.println("Unable to send message["+message+"]"+"due to =["+ex.getMessage()+"]");
            }
        });
    }
}
