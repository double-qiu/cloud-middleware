package com.middleware.cache.redis.springcache;

import java.io.Serializable;

public class TestBean implements Serializable {
	private static final long serialVersionUID = -8571228536590805759L;
	private static int currentId;
    private Integer id;
    private String userName;
    private String loginName;
    private Integer queryId;

    public Integer getQueryId() {
        return queryId;
    }

    public void setQueryId(Integer queryId) {
        this.queryId = queryId;
    }

    public TestBean() {
        id = ++currentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", queryId=" + queryId +
                '}';
    }
}
