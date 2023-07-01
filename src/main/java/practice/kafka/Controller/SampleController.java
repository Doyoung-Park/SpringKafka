package practice.kafka.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import practice.kafka.service.KafkaProducer;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/kafka/test")
@RequiredArgsConstructor
public class SampleController {

    private final KafkaProducer producer;

    @PostMapping(value = "/message")
    public String sendMessage(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
        return "success";
    }
}