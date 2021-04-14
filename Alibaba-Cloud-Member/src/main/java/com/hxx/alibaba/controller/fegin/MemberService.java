package com.hxx.alibaba.controller.fegin;


import com.hxx.alibaba.repository.entity.DataReceiveRecordEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "alibaba-cloud-provder", fallback = SentinelExceptionHandler.class)
public interface MemberService {


    @RequestMapping("/provder/selectById")
    DataReceiveRecordEntity selectById(@RequestParam("id") String id);

    @RequestMapping("/provder/insert")
    DataReceiveRecordEntity insert(@RequestBody DataReceiveRecordEntity entity);

    @RequestMapping("/provder/update")
    DataReceiveRecordEntity update(@RequestBody Map<String, String> params);

    @RequestMapping("/provder/queryList")
    List<DataReceiveRecordEntity> queryList();
}
