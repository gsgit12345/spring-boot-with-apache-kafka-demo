package com.example.eventhandler;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class WikkiMediaChangeHandler implements EventHandler {

    private String topic;
    private static final Logger LOGGER= LoggerFactory.getLogger(WikkiMediaChangeHandler.class);

    public WikkiMediaChangeHandler(String topic, KafkaTemplate<String, String> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    private KafkaTemplate<String,String> kafkaTemplate;
    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        LOGGER.info("message received in Onmessage->%s",messageEvent.getData());
        kafkaTemplate.send(topic,messageEvent.getData());

    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
