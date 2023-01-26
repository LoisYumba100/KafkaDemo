package com.streamsD.streamsD.config

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class TestConsumer {
    @KafkaListener(topics = ["topicTwo"], groupId = "group_id",containerFactory = "kafkaListenerContainerFactory")
    fun listenGroupFoo(course:String) {
        println(course)

    }
}