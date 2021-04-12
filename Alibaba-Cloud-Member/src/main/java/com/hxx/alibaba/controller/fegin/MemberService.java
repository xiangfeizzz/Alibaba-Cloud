package com.hxx.alibaba.controller.fegin;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "alibaba-cloud-provder",fallback = SentinelExceptionHandler.class)
public interface MemberService {

    @RequestMapping("/provder/getName")
    public String getName(@RequestParam("name")  String name);
}
