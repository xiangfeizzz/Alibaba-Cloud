package com.hxx.alibaba.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxx.alibaba.entity.PermissionEntry;
import com.hxx.alibaba.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/11 16:44
 */
@Service
public class PermissionService extends ServiceImpl<PermissionMapper, PermissionEntry> {


    public List<PermissionEntry> getPermissionsByUserId(Integer userId){
        return baseMapper.selectPermissionsByUserId(userId);
    }

}
