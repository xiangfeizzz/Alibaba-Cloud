package com.hxx.alibaba.controller;

import com.alibaba.fastjson.JSONObject;
import com.hxx.alibaba.controller.fegin.MemberService;
import com.hxx.alibaba.repository.entity.VmTemplateEntity;
import com.hxx.alibaba.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/member2")
@RefreshScope
public class MemberController2 {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    MemberService memberService;
    @Autowired
    ProviderService providerService;
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * getIpAndPort
     * @return
     */
    @GetMapping("/getIpAndPort")
    public String getIpAndPort() {
        return this.restTemplate.getForObject("http://alibaba-cloud-provder/provder/getIpAndPort", String.class);
    }

    /**
     * 根据id查询
     *
     * @return
     */
    @GetMapping("/selectById")
    public VmTemplateEntity selectById(String id) {
        VmTemplateEntity entity = restTemplate.getForObject("http://alibaba-cloud-provder/provder/selectById?id=" + id, VmTemplateEntity.class);
        return entity;
    }

    /**
     * 获取列表
     *
     * @return
     */
    @GetMapping("/queryList")
    public String  queryList() {
        //ribbon调用
        VmTemplateEntity[] entityArray=restTemplate.getForObject("http://alibaba-cloud-provder/provder/queryList", VmTemplateEntity[].class);
        List<VmTemplateEntity> entityList= Arrays.asList(entityArray);

        for(VmTemplateEntity e:entityList){
            System.out.println("id->"+e.getId());
        }
        return JSONObject.toJSONString(entityList) ;
       }



    /**
     * 修改
     * @return
     */
    @GetMapping("/update")
    public VmTemplateEntity update(String id, String template) {
        VmTemplateEntity entity = new VmTemplateEntity();
        entity.setId(id);
        entity.setTemplate(template);
        HashMap<String,String> map=new HashMap<>();
        map.put("id",id);
        map.put("template",template);
        //ribbon调用
        ResponseEntity<VmTemplateEntity> entityReturn = restTemplate.postForEntity("http://alibaba-cloud-provder/provder/update", entity, VmTemplateEntity.class);
        return entityReturn.getBody();

    }

    /**
     * 新增
     *
     * @return
     */
    @GetMapping("/insert")
    public VmTemplateEntity insert() {
        VmTemplateEntity entity = new VmTemplateEntity();
        entity.setTemplate("测试");

        //ribbon调用
        ResponseEntity<VmTemplateEntity> entityReturn = restTemplate.postForEntity("http://alibaba-cloud-provder/provder/insert", entity, VmTemplateEntity.class);
        return entityReturn.getBody();

    }

    /**
     * 根据id删除
     *
     * @return
     */
    @GetMapping("/deleteById")
    public String deleteById(String id) {
        //ribbon调用
        int i = restTemplate.getForObject("http://alibaba-cloud-provder/provder/deleteById?id=" + id, int.class);
        return "删除成功";
    }



}
