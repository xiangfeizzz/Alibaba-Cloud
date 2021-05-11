package com.hxx.alibaba.rocketMq;//package com.hxx.alibaba.controller.rocketMq;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//
//@Slf4j
//@Service
//@RocketMQMessageListener(consumerGroup = "myConsumer", topic = "myTopic")
//public class RocketMqService implements RocketMQListener<HashMap> {
//    @Override
//    public void onMessage(HashMap map) {
//        System.out.println("接受到消息" + map.toString());
//    }
//}
