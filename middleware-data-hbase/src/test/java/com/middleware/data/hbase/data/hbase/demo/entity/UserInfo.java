package com.middleware.data.hbase.data.hbase.demo.entity;

import com.middleware.data.hbase.annotation.Column;
import com.middleware.data.hbase.annotation.HbaseTeable;
import com.middleware.data.hbase.annotation.RowKey;

/**
 * Created by DOUBLE on 2017/04/11.
 *
 * @author DOUBLE
 * @since 2017/04/11
 */
@HbaseTeable(tableName = "user", family = "info")
public class UserInfo {

    @RowKey
    private String id;

    @Column(qualifier = "user_a")
    private String userName;

    @Column
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
