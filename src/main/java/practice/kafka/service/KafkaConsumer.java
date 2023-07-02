package practice.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class KafkaConsumer {

    @KafkaListener(topics = "test1", groupId = ConsumerConfig.GROUP_ID_CONFIG)
    public void Test1Consume(String message) throws IOException {
        System.out.println("This is KafkaConsumer.Test1Consume");
        System.out.println("Consumed message is: " + "'"+message+"'");
    }

    @KafkaListener(topics = "test2", groupId = ConsumerConfig.GROUP_ID_CONFIG)
    public void Test2Consume(String message) throws IOException {
        System.out.println("This is KafkaConsumer.Test2Consume");
        System.out.println("Consumed message is: " + "'"+message+"'");
    }
}