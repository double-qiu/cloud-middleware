package com.middleware.ssm.dao;

import com.middleware.ssm.entity.BaseEntity;

/**
 * @author DOUBLE
 */
public interface BaseDao<Entity extends BaseEntity> {

    /**
     * 获取单条数据
     */
    public Entity findOne(Long id);

    /**
     * 插入数据
     */
    public int insert(Entity entity);

    /**
     * 更新数据
     */
    public int update(Entity entity);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     */
    public int delete(Long id);
}
