package com.wuho.SpringSecEx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public KafkaService(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    public void sendMsg(String msg) {
        kafkaProducerService.sendSchoolMessage(msg);
    }

    @KafkaListener(topics = "school", groupId = "groupId")
    public void listener(String data) {
        System.out.println("Application received: " + data );
    }
}
