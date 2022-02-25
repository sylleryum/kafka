package com.sylleryum.producerentity2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProducerEntity2Application {

    public static void main(String[] args) {
        SpringApplication.run(ProducerEntity2Application.class, args);
    }

}
