package com.gx.car.model;

import java.util.Date;

public class Prime {
    private Integer id;

    private String primeName;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrimeName() {
        return primeName;
    }

    public void setPrimeName(String primeName) {
        this.primeName = primeName == null ? null : primeName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}