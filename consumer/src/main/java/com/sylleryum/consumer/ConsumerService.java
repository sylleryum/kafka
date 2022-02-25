package com.sylleryum.consumer;

import com.sylleryum.producer.entity.Entity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "teste")
//    public void consume(ConsumerRecord<String,String> s){
    public void consume(Entity entityTest) {

//        System.out.println("Topic "+s.topic()+
//                "\n key "+s.key()+
//                "\n offset "+s.offset()+" " +
//                "\n partition "+s.partition()+
//                "\n value "+s.value());
        System.out.println("===================");
        System.out.println(entityTest.getName());

    }
}