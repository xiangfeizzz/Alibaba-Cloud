package com.hxx.alibaba.controller.fegin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SentinelExceptionHandler implements MemberService{

    final static Logger logger = LoggerFactory.getLogger(SentinelExceptionHandler.class);

    @Override
    public String getName(String name) {
        logger.info("sentinel 熔断处理 {}", "SentinelExceptionHandler");
        return "Sentinel {由于你的访问次数太多，已为你限流、您已进入保护模式，请稍后再试！}>>>熔断处理函数";
    }

}
