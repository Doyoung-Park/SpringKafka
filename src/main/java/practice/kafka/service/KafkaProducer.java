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

    private final KafkaTemplate<String, String> customKafkaTemplate;  // 카프카 템플릿을 하기 위해 @autowired 해주는 부분

    public void sendMessage(String message) {
        System.out.println("produced message is: " + "'"+message+"'");
        System.out.println("topic name is: " + "'"+topicName+"'");
        this.customKafkaTemplate.send(topicName, message);    // 다양한 send() 옵션이 있기는 하다.
    }
}