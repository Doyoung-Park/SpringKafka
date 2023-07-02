package practice.kafka.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTemplateConfig {
    @Bean
    public KafkaTemplate<String, String> customKafkaTemplate() {    // 카프카 템플릿 객체를 리턴하는 빈(Bean) 객체.

        Map<String, Object> props = new HashMap<>();    // 카프카 프로듀서 옵션을 직접 넣는다.
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.ACKS_CONFIG, "all");

        // 카프카 템플릿 객체를 만들기 위한 프로듀서팩토리(ProducerFactory)를 초기화 한다.
        ProducerFactory<String, String> pf = new DefaultKafkaProducerFactory<>(props);

        return new KafkaTemplate<>(pf); // 프로듀서팩토리(ProducerFactory)클래스로 카프카 템플릿 객체를 생성하여 리턴한다.
    }
}
