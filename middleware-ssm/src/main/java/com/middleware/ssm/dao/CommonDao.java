package com.middleware.ssm.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * DAO支持类实现
 *
 * @author DOUBLE
 * @version 2016-01-15
 */
@Repository
public class CommonDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public <E> E findForObject(String str, Object obj) {
        return sqlSessionTemplate.selectOne(str, obj);
    }

    public <E> List<E> findForList(String str, Object obj) {
        return sqlSessionTemplate.selectList(str, obj);
    }

    public <K, V> Map<K, V> findForMap(String str, Object obj, String key) {
        return sqlSessionTemplate.selectMap(str, obj, key);
    }

    public int delete(String statement, Object parameter) {
        return sqlSessionTemplate.delete(statement, parameter);
    }

    public int update(String statement, Object parameter) {
        return sqlSessionTemplate.update(statement, parameter);
    }

}