package com.hxx.alibaba.controller;

import com.hxx.alibaba.repository.entity.VmTemplateEntity;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/seata")
public class SeataController {

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

        VmTemplateEntity entity = new VmTemplateEntity();
        entity.setTemplate("测试");
        //ribbon调用
        ResponseEntity<VmTemplateEntity> entityReturn = restTemplate.postForEntity("http://alibaba-cloud-provder/provder/insert", entity, VmTemplateEntity.class);
        return "success";
    }


}
