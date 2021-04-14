package com.hxx.alibaba.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hxx.alibaba.repository.dao.DataReceiveRecordDao;
import com.hxx.alibaba.repository.entity.DataReceiveRecordEntity;
import com.hxx.alibaba.repository.service.IDataReceiveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/provder")
public class ProvderController {

    @Autowired
    private Registration registration;

    @Autowired
    private DataReceiveRecordDao DataReceiveRecordDao;

    @Autowired
    private IDataReceiveRecordService IDataReceiveRecordService;

    @RequestMapping("/getIpAndPort")
    public String getIpAndPort() {
        return registration.getHost() + ":" + registration.getPort();
    }

    @RequestMapping("/selectById")
    public DataReceiveRecordEntity selectById(String id) {
        DataReceiveRecordEntity dataReceiveRecordEntity = DataReceiveRecordDao.selectById(id);
        return dataReceiveRecordEntity;
    }

    @RequestMapping("/queryList")
    public List<DataReceiveRecordEntity> query() {
        LambdaQueryWrapper<DataReceiveRecordEntity> lqw = new LambdaQueryWrapper<>();
        List<DataReceiveRecordEntity> list = IDataReceiveRecordService.list();
        return list;
    }

    @RequestMapping("/insert")
    public DataReceiveRecordEntity insert(@RequestBody DataReceiveRecordEntity entity) {
        DataReceiveRecordDao.insert(entity);
        return entity;
    }

    @RequestMapping("/update")
    public DataReceiveRecordEntity update(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        String remark = map.get("remark");
        DataReceiveRecordEntity entity = DataReceiveRecordDao.selectById(id);
        entity.setId(id);
        entity.setDataRemark(remark);
        DataReceiveRecordDao.updateById(entity);
        return entity;
    }


}
