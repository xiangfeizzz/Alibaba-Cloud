package com.hxx.alibaba.controller;

import com.hxx.alibaba.repository.dao.DataReceiveRecordDao;
import com.hxx.alibaba.repository.service.IDataReceiveRecordService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private Registration registration;

    @Autowired
    private DataReceiveRecordDao DataReceiveRecordDao;

    @Autowired
    private IDataReceiveRecordService IDataReceiveRecordService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/save")
    public String save(){
        this.jdbcTemplate.update("insert into account(balance) values ('100')");
        return "success";
    }

    @RequestMapping("/save2")
    @GlobalTransactional
    public String save2() {
        this.jdbcTemplate.update("insert into account(balance) values ('200')");
        int a=2/0;
        String payResult=restTemplate.getForObject("http://pay/pay/save",  String.class);
        return "success";
    }


}
