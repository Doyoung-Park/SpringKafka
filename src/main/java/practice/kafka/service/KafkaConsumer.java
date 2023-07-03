package practice.kafka.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.kafka.subDB.model.Alert;
import practice.kafka.subDB.repository.AlertRepository;

import java.io.IOException;
import java.sql.Timestamp;


@Service
@RequiredArgsConstructor
@Transactional
public class KafkaConsumer {

    private final AlertRepository alertRepository;

    @KafkaListener(topics = "test", groupId = ConsumerConfig.GROUP_ID_CONFIG)
    public void consume(String message) throws IOException {
        System.out.println("Consumed message is: " + "'"+message+"'");
    }

    @KafkaListener(topics = "alert", groupId = ConsumerConfig.GROUP_ID_CONFIG)
    public void alert(String price) throws IOException {
        System.out.println("Consumed price is: " + "'"+price+"'");
        Alert alert = new Alert();
        alert.setTime( new Timestamp(23));
        alert.setPrice(price);
        alertRepository.save(alert);
        System.out.println("alert 가 저장됨.");
    }
}