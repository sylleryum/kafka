package com.sylleryum.producerentity2;

import com.sylleryum.producer.entity.Entity2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FixedRateProducer {

//	@Autowired
//	private KafkaTemplate<String, Entity> kafkaTemplate;

	@Autowired
	private KafkaTemplate<Long, Entity2> kafkaTemplate;

	private Long i = 0l;

	private Logger log = LoggerFactory.getLogger(FixedRateProducer.class);

	@Scheduled(fixedRate = 1000)
	public void sendMessage() {
		i++;
		log.info("i is " + i);

		var entityTest2 = new Entity2("anickname!");

		kafkaTemplate.send("teste2", i, entityTest2);
		
//		kafkaTemplate.send("t1", String.valueOf(i), i+" - "+
//		LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
	}

}
