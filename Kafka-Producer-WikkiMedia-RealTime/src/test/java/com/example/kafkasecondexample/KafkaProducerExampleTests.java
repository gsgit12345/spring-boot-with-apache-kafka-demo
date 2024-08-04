package com.example.kafkasecondexample;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
public class KafkaProducerExampleTests {
    //https://docs.confluent.io/cloud/current/clusters/replicator-cloud-quickstart.html
    @Container
    static public KafkaContainer kafkaContainer=new KafkaContainer(DockerImageName.parse("confluentinc/cp-server:latest").asCompatibleSubstituteFor("apache/kafka"));
    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;
    @DynamicPropertySource
    public  static void initKafkaProperties(DynamicPropertyRegistry registry)
    {
        registry.add("spring.kafka.bootstrap-servers",kafkaContainer::getBootstrapServers);
    }

    @Test
    public void testSendMessageToTopic()
    {
        kafkaMessagePublisher.sendMessageToTopic("test container testing the kafka test case");
await().pollInterval(Duration.ofSeconds(10)).atMost(10, TimeUnit.SECONDS).untilAsserted(()->
        {

        }
        );
    }


}
