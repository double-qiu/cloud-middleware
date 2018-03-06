package com.middleware.mybatis.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.middleware.mybatis.entity.Astudent;

@Mapper
public interface AstudentDao {


    /**
     * 获取单条数据
     */
    public Astudent findOne(Long id);

    /**
     * 插入数据
     */
    public int insert(Astudent entity);

    /**
     * 更新数据
     */
    public int update(Astudent entity);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     */
    public int delete(Long id);

    Astudent findByRealNameAndNickname(@Param("realName") String realName, @Param("nickname") String nickname);
}
