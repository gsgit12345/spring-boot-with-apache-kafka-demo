package com.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

@Bean
    public NewTopic createTopicInKafka()
    {
        return TopicBuilder.name("FirstTopic").partitions(10).build();
    }

    @Bean
    public NewTopic createJsonTopicInKafka()
    {
        return TopicBuilder.name("FirstJsonTopic").partitions(10).build();
    }

}
