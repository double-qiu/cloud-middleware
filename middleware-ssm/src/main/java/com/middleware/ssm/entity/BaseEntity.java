package com.middleware.ssm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity支持类
 *
 * @author DOUBLE 2016年6月28日
 */
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = -6885473810414648724L;
	public static final boolean DEL_FLAG_NORMAL = false;
    public static final boolean DEL_FLAG_DELETE = true;
    private Long id;
    private Date createTime;
    private Date updateTime;
    private boolean deleted;

    public BaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
