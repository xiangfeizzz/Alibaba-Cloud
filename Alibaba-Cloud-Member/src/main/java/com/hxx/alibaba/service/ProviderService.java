package com.hxx.alibaba.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {

    @SentinelResource("link")
    public String link(){
        return "link";
    }
}
