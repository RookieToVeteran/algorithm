package com.algorithm.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: kafka
 * @description: kafka生产者
 * @author: pengpeng.wang.o
 * @create: 2019-08-13
 **/
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @GetMapping("/message/send")
    public boolean send(@RequestParam String message){
        System.out.println("=============向生产者推送消息--------开始");
        kafkaTemplate.send("testTopic",message);
        System.out.println("=============向生产者推送消息--------完成");
        return true;
    }
}
