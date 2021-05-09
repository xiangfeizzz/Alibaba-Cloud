package com.hxx.alibaba.security.service;


import com.alibaba.fastjson.JSON;
import com.hxx.alibaba.entity.PermissionEntry;
import com.hxx.alibaba.entity.UserEntity;
import com.hxx.alibaba.service.PermissionService;
import com.hxx.alibaba.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/9 23:24
 */
@Service
@Slf4j
public class SecurityUserDetailService implements UserDetailsService {


    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;


    @Override
    public UserDetails loadUserByUsername(String username) {

        UserEntity user = userService.getUserByUsername(username);
        if (user == null) {
            return null;
        }
        //获取权限
        List<PermissionEntry> permissions = permissionService.getPermissionsByUserId(user.getId());
        List<String> urls = permissions.stream().map(PermissionEntry::getUrl).collect(Collectors.toList());
        String[] authorities = null;
        if (CollectionUtils.isNotEmpty(urls)) {
            authorities = new String[urls.size()];
            urls.toArray(authorities);
        }
        //身份令牌
        String principal = JSON.toJSONString(user);
        return User.withUsername(principal).password(user.getPassword()).authorities(authorities).build();
    }
}
