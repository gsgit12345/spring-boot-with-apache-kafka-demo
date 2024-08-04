package com.example.kafkasecondexample;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.kafka.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@Slf4j
public class KafkaConsumerExampleTests {
    @Container
    static public KafkaContainer kafkaContainer=new KafkaContainer(DockerImageName.parse("confluentinc/cp-server:latest").asCompatibleSubstituteFor("apache/kafka"));

    @Autowired
    private KafkaTemplate<String,Object> template;
    @DynamicPropertySource
    public  static void initKafkaProperties(DynamicPropertyRegistry registry)
    {
        registry.add("spring.kafka.bootstrap-servers",kafkaContainer::getBootstrapServers);
    }

    @Test
    public void testMessageConsume()
    {
        log.info("testMessageConsume executed");
        template.send("first","hello i am consumer");
    }

}
