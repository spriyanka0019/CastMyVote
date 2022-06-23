package com.example.countingservice.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerListener {

    @KafkaListener(topics="VotingBoard",groupId = "group_id",containerFactory = "kafkaListenerContainerFactory" )
    public  void consumeMessage(String message){
        System.out.println(
                message
        );
    }


//    @KafkaListener(topics = "VotingBoard", groupId = "group_json",
//            containerFactory = "userKafkaListenerFactory")
//    public void consumeJson(User user) {
//        System.out.println("Consumed JSON Message: " + user);
//    }
}
