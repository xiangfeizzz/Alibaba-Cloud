package com.hxx.alibaba.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hxx.alibaba.repository.dao.VmTemplateDao;
import com.hxx.alibaba.repository.entity.VmTemplateEntity;
import com.hxx.alibaba.repository.service.IVmTemplateService;
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
    private VmTemplateDao VmTemplateDao;

    @Autowired
    private IVmTemplateService IVmTemplateService;

    @RequestMapping("/getIpAndPort")
    public String getIpAndPort() {
        try{Thread.sleep(4000);}catch(Exception e){e.printStackTrace();}
        return registration.getHost() + ":" + registration.getPort();
    }

    @RequestMapping("/selectById")
    public VmTemplateEntity selectById(String id) {
        VmTemplateEntity VmTemplateEntity = VmTemplateDao.selectById(id);
        return VmTemplateEntity;
    }

    @RequestMapping("/queryList")
    public List<VmTemplateEntity> query() {
        LambdaQueryWrapper<VmTemplateEntity> lqw = new LambdaQueryWrapper<>();
        List<VmTemplateEntity> list = IVmTemplateService.list();
        return list;
    }

    @RequestMapping("/insert")
    public VmTemplateEntity insert(@RequestBody VmTemplateEntity entity) {
        VmTemplateDao.insert(entity);
        return entity;
    }

    @RequestMapping("/deleteById")
    public int deleteById(String id) {
        int i=VmTemplateDao.deleteById(id);
        return i;
    }

    @RequestMapping("/update")
    public VmTemplateEntity update(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        String template = map.get("template");
        VmTemplateEntity entity = VmTemplateDao.selectById(id);
        entity.setId(id);
        entity.setTemplate(template);
        VmTemplateDao.updateById(entity);
        return entity;
    }


}
