package com.hxx.alibaba.controller.fegin;

import com.hxx.alibaba.repository.entity.VmTemplateEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SentinelExceptionHandler implements MemberService {

    final static Logger logger = LoggerFactory.getLogger(SentinelExceptionHandler.class);


    @Override
    public String getIpAndPort() {
        System.out.println("feign获取getIpAndPort 异常");
        return "feign获取getIpAndPort 异常";
    }

    @Override
    public VmTemplateEntity selectById(String name) {
        System.out.println("sentinel 熔断处理 selectById");
        VmTemplateEntity entity=new VmTemplateEntity();
        entity.setTemplate("默认");
        return entity;
    }

    @Override
    public VmTemplateEntity insert(VmTemplateEntity entity) {
        System.out.println("sentinel 熔断处理 insert");
        return null;
    }

    @Override
    public VmTemplateEntity update(Map<String, String> params) {
        System.out.println("sentinel 熔断处理 update");
        return null;
    }

    @Override
    public List<VmTemplateEntity> queryList() {
        System.out.println("sentinel 熔断处理 queryList");
        return null;
    }

    @Override
    public int deleteById(String id) {
        System.out.println("sentinel 熔断处理 deleteById");
        return 0;
    }
}
