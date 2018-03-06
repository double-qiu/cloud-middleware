package com.middleware.mybatis.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.middleware.mybatis.entity.Astudent;

@Service
public class AstudentService {
    @Autowired
    private SaveService saveService;

    public void test() {
        for (int i = 0; i < 10000; i++) {
            Astudent astudent = new Astudent();
            astudent.setBirthday(new Date());
            astudent.setNickname("sadsf");
            astudent.setEmail("df");
            astudent.setLoginName("sas");
            astudent.setSourceFrom(i);
            saveService.save(astudent);
        }
    }
}
