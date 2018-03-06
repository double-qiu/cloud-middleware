package com.middleware.mybatis.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.middleware.mybatis.dao.AstudentDao;
import com.middleware.mybatis.entity.Astudent;

@Service
public class SaveService {
    @Autowired
    private AstudentDao dao;

    @Transactional
    public void save(Astudent astudent) {
        dao.insert(astudent);
        System.out.println(astudent.getId());
        dao.update(astudent);
    }
}
