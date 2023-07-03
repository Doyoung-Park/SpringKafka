package practice.kafka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.kafka.mainDB.model.Bitcoin;
import practice.kafka.mainDB.repository.BitcoinRepository;


@Service
@RequiredArgsConstructor
@Transactional
public class KafkaProducer {

    @Value(value = "test")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;  // 생성한 디폴트 카프카 템플릿을 injection 하는 부분

    private final BitcoinRepository bitcoinRepository;

    public void sendMessage(String message) {
        System.out.println("produced message is: " + "'"+message+"'");
        System.out.println("topic name is: " + "'"+topicName+"'");
        this.kafkaTemplate.send(topicName, message);
    }

    public void saveBitcoinPrice(String price) {
        Bitcoin bitcoin = new Bitcoin();
        bitcoin.setPrice(price);
        bitcoinRepository.save(bitcoin);
        System.out.println("bitcoin이 저장됨.");

        if (Integer.parseInt(price) >= 100000) {
            this.kafkaTemplate.send("alert", price);
            System.out.println("alert 가 전송됨.");
        }

    }
}