package com.hxx.alibaba.controller.fegin;

import com.hxx.alibaba.repository.entity.DataReceiveRecordEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SentinelExceptionHandler implements MemberService {

    final static Logger logger = LoggerFactory.getLogger(SentinelExceptionHandler.class);


    @Override
    public DataReceiveRecordEntity selectById(String name) {
        System.out.println("sentinel 熔断处理");
        return null;
    }

    @Override
    public DataReceiveRecordEntity insert(DataReceiveRecordEntity entity) {
        return null;
    }

    @Override
    public DataReceiveRecordEntity update(Map<String, String> params) {
        return null;
    }

    @Override
    public List<DataReceiveRecordEntity> queryList() {
        return null;
    }
}
