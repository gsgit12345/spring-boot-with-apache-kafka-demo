package com.example;

import com.example.producer.WikkiMediaKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class SpringBootProducer //implements CommandLineRunner

{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringBootProducer.class,args);
        System.out.println( "Hello World!" );
    }
/*
    @Autowired
    private WikkiMediaKafkaProducer producer;
    @Override
    public void run(String... args) throws Exception {
     producer.sendMessage();
    }*/
}
