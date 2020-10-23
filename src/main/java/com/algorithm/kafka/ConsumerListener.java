package com.algorithm.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @program: kafka
 * @description: kafka监听
 * @author: pengpeng.wang.o
 * @create: 2019-08-13
 **/
@Component
public class ConsumerListener {

//    @KafkaListener(topics = "testTopic")
    public void onMessage(String message){
        System.out.println("=======开始消费kafka消息=======");
        System.out.println(message);
        System.out.println("=======kafka消息消费结束=======");
    }
}
