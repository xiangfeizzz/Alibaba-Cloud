package com.hxx.alibaba.controller;

import io.seata.spring.annotation.GlobalTransactional;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private Registration registration;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    @RequestMapping("/save")
    public String save(){
        String id=UUID.randomUUID().toString().replace("-","").substring(10);
        LocalDateTime createTime = LocalDateTime.now();
        String inserSql="insert into DATA_RECEIVE_RECORD(id,data_type,data_remark,total_num,succ_num) values ('"+id+"','1','seate测试','1','1')";
        System.out.println("inserSql-->"+inserSql);
        this.jdbcTemplate.update(inserSql);
        return "success";
    }

    @RequestMapping("/save2")
    @GlobalTransactional
    public String save2() {
        String id=UUID.randomUUID().toString().replace("-","").substring(10);
        LocalDateTime createTime = LocalDateTime.now();
        String inserSql="insert into DATA_RECEIVE_RECORD(id,data_type,data_remark,total_num,succ_num) values ('"+id+"','1','seate测试','1','1')";
        System.out.println("inserSql-->"+inserSql);
        this.jdbcTemplate.update(inserSql);
        int a=2/0;
        String payResult=restTemplate.getForObject("http://pay/pay/save",  String.class);
        return "success";
    }

    @RequestMapping("/testMq")
    public String testMq(){
        Map map=new HashMap<String,String>();
        map.put("key","测试rocketMq");
        this.rocketMQTemplate.convertAndSend("myTopic" ,map);
        return "success";
    }

}
