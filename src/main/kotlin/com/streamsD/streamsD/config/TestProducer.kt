package com.streamsD.streamsD.config

import com.streamsD.streamsD.model.Course
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class TestProducer(
    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    @PostConstruct
    fun test(){
        val courses = mutableListOf<Course>()
        courses.add(Course("science",78))
        courses.add(Course("mathematics", 69))
        courses.add(Course("english", 85))
        val json = """
          [
            {
              "course":"science",
              "marks":78
              
            },
            {
              "course":"mathematics",
              "marks":69
            },
            {
               "course":"mathematics",
               "marks":69
            
            }
          ]"""
        kafkaTemplate.send("topicTwo",json)
        kafkaTemplate.flush()

    }

}