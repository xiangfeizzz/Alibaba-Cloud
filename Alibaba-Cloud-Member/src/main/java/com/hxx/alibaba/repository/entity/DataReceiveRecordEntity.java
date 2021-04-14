package com.hxx.alibaba.repository.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DataReceiveRecordEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String dataType;

    private String dataRemark;

    private String totalNum;

    private String succNum;

    private String createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataRemark() {
        return dataRemark;
    }

    public void setDataRemark(String dataRemark) {
        this.dataRemark = dataRemark;
    }

    public String getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    public String getSuccNum() {
        return succNum;
    }

    public void setSuccNum(String succNum) {
        this.succNum = succNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
