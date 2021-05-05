package com.hxx.alibaba.controller.fegin;


import com.hxx.alibaba.repository.entity.VmTemplateEntity;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "alibaba-cloud-provder", fallback = SentinelExceptionHandler.class)
public interface MemberService {

    @RequestMapping("/provder/getIpAndPort")
    String getIpAndPort();

    @RequestMapping("/provder/getIpAndPort2")
    String getIpAndPort2();

    @RequestMapping("/provder/selectById")
    VmTemplateEntity selectById(@RequestParam("id") String id);

    @RequestMapping("/provder/insert")
    VmTemplateEntity insert(@RequestBody VmTemplateEntity entity);

    @RequestMapping("/provder/update")
    VmTemplateEntity update(@RequestBody Map<String, String> params);

    @RequestMapping("/provder/queryList")
    List<VmTemplateEntity> queryList();

    @RequestMapping("/provder/deleteById")
    int deleteById(@RequestParam("id") String id);

}
