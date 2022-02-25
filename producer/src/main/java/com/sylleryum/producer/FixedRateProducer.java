package com.sylleryum.producer;

import com.sylleryum.producer.entity.Entity;
import com.sylleryum.producer.entity.Entity2;
import com.sylleryum.producer.entity.EntityTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FixedRateProducer {

	@Autowired
	private KafkaTemplate<Long, Entity> kafkaTemplate;

//	@Autowired
//	private KafkaTemplate<String, Entity2> kafkaTemplate;

	private Long i = 0l;

	private Logger log = LoggerFactory.getLogger(FixedRateProducer.class);

	@Scheduled(fixedRate = 1000)
	public void sendMessage() {
		i++;
		log.info("i is " + i);

		var entityTest = new Entity("hello","world");
		var entityTest2 = new Entity2("anickname!");

		kafkaTemplate.send(
//				MessageBuilder.withPayload(entityTest)
//						.setHeader(KafkaHeaders.TOPIC, "teste")
//						.build()
				MessageBuilder.withPayload(entityTest)
						.setHeader("hash", entityTest.hashCode())
						.setHeader("version", "1.0.0")
						.setHeader("endOfLife", LocalDate.now().plusDays(1L))
						.setHeader("type", "fct")
						.setHeader("cid", i)
						.setHeader(KafkaHeaders.TOPIC, "teste")
						.setHeader(KafkaHeaders.MESSAGE_KEY, i)
						.build()
		);

//		kafkaTemplate.send("teste2", String.valueOf(i), entityTest2);

//		kafkaTemplate.send("t1", String.valueOf(i), i+" - "+
//		LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
	}

}
