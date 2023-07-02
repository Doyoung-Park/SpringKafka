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

    private final KafkaTemplate<String, String> kafkaTemplate;  // 생성한 디폴트 카프카 템플릿을 injection 하는 부분

    public void sendMessage(String message) {
        System.out.println("produced message is: " + "'"+message+"'");
        System.out.println("topic name is: " + "'"+topicName+"'");
        this.kafkaTemplate.send(topicName, message);
    }
}