package practice.kafka.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import practice.kafka.mainDB.model.Bitcoin;
import practice.kafka.mainDB.repository.BitcoinRepository;
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

    @PostMapping(value = "/bringPrice")
    public String bringPrice(@RequestParam("price") String price) {
        System.out.println("SampleController.bringPrice");
        System.out.println("price = " + price);

        this.producer.saveBitcoinPrice(price);


        return "success for bring price";
    }
}