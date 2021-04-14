package com.bocs.obtm.bcm.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据接收记录表
 * </p>
 *
 * @author xuchenchen
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("DATA_RECEIVE_RECORD")
public class DataReceiveRecordEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("ID")
    private String id;

    /**
     * 业务数据类型
     */
    @TableField("DATA_TYPE")
    private String dataType;

    /**
     * 数据类型描述
     */
    @TableField("DATA_REMARK")
    private String dataRemark;

    /**
     * 文件中总记录条数
     */
    @TableField("TOTAL_NUM")
    private String totalNum;

    /**
     * 成功入库数量
     */
    @TableField("SUCC_NUM")
    private String succNum;

    /**
     * 创建日期
     */
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}
