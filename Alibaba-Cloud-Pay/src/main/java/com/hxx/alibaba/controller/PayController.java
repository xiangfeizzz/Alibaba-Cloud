package com.hxx.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private Registration registration;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/save")
    public String save(){
        this.jdbcTemplate.update("insert into account(balance) values ('300')");
        return "success";
    }


}
