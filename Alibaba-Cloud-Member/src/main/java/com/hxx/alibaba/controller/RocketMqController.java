//package com.hxx.alibaba.controller;
//
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/rocketMq")
//public class RocketMqController {
//
//    @Autowired
//    private RocketMQTemplate rocketMQTemplate;
//
//    @RequestMapping("/testMq")
//    public String testMq(){
//        Map map=new HashMap<String,String>();
//        map.put("key","测试rocketMq");
//        this.rocketMQTemplate.convertAndSend("myTopic" ,map);
//        return "success";
//    }
//
//}
