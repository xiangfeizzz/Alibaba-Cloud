package com.hxx.alibaba.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 模板记录表
 * </p>
 *
 * @author xuchenchen
 * @since 2021-04-15
 */
@Data
@TableName("VM_TEMPLATE")
public class VmTemplateEntity implements Serializable {


    private static final long serialVersionUID = 5757882886048578430L;
    @TableId(type = IdType.UUID)
    private String id;

    /**
     * 模板列
     */
    @TableField("TEMPLATE")
    private String template;


}
