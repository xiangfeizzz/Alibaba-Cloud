package com.hxx.alibaba.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxx.alibaba.entity.UserEntity;
import com.hxx.alibaba.mapper.UserMapper;
import org.springframework.stereotype.Service;


/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/10 01:19
 */
@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity> {

    public UserEntity getUserByUsername(String username) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return baseMapper.selectOne(wrapper);
    }

}
