package practice.kafka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class KafkaProducer {

    @Value(value = "test")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        System.out.println("produced message is: " + "'"+message+"'");
        System.out.println("topic name is: " + "'"+topicName+"'");
        this.kafkaTemplate.send(topicName, message);
    }
}