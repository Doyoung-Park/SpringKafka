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

    @Value(value = "test1")
    private String topicName1;

    @Value(value = "test2")
    private String topicName2;


    private final KafkaTemplate<String, String> kafkaTemplate;  // 생성한 디폴트 카프카 템플릿을 injection 하는 부분

    public void sendMessage(String message) {
        System.out.println("produced message is: " + "'"+message+"'");
        if (message.equals("test")) {
            System.out.println("** message Test = " + message);
            this.kafkaTemplate.send(topicName2, message);
        }
        else{
            this.kafkaTemplate.send(topicName1, message);
        }


    }
}