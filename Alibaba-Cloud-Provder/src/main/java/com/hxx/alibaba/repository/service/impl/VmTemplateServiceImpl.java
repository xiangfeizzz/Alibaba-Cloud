package com.hxx.alibaba.repository.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxx.alibaba.repository.dao.VmTemplateDao;
import com.hxx.alibaba.repository.entity.VmTemplateEntity;
import com.hxx.alibaba.repository.service.IVmTemplateService;
import org.springframework.stereotype.Service;

@Service
public class VmTemplateServiceImpl  extends ServiceImpl<VmTemplateDao, VmTemplateEntity> implements IVmTemplateService {
}
