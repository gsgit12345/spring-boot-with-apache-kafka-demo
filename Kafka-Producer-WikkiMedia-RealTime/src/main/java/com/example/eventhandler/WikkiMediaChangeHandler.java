package com.example.eventhandler;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class WikkiMediaChangeHandler implements EventHandler {

    private String topic;
    private static final Logger LOGGER= LoggerFactory.getLogger(WikkiMediaChangeHandler.class);
    private KafkaTemplate<String,String> kafkaTemplate;

    public WikkiMediaChangeHandler( KafkaTemplate<String, String> kafkaTemplate,String topic) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        LOGGER.info(String.format("message received-->%s",messageEvent.getData()));

        kafkaTemplate.send(topic,messageEvent.getData());

        //System.out.println("date ::::"+messageEvent.getData());

    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
