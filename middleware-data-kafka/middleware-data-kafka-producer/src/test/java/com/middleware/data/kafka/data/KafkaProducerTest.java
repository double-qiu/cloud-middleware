package com.middleware.data.kafka.data;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.middleware.data.kafka.producer.KafkaProducer;


/**
 * Unit test for simple App.
 *
 * Created by ${USER} on ${DATE}.
 */
public class KafkaProducerTest{

    @Autowired
    KafkaProducer kafkaProducer;

    @Test
    public void producer() {
        kafkaProducer.send("hello", "aaaaa");
    }

}