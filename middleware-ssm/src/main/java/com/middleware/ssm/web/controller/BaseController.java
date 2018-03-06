package com.middleware.ssm.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.middleware.ssm.vo.BaseResponse;
import com.middleware.ssm.vo.DataResponse;
import com.middleware.ssm.vo.UserInfo;

/**
 * mvc异常工具
 *
 * @author Fe 2016年5月16日
 */
public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected static final BaseResponse SUCCESS = new UnModifyResponse(0, "success");

    /**
     * 返回错误响应封装。code=6
     */
    public BaseResponse error(String message) {
        return error(6, message);
    }

    /**
     * 返回错误的响应封装
     */
    public BaseResponse error(int code, String message) {
        return new BaseResponse(code, message);
    }

    /**
     * 返回data的响应封装
     */
    public <T> DataResponse<T> data(T data) {
        return new DataResponse<>(data);
    }

    /**
     * 返回data和total的响应封装
     */
    public <T> DataResponse<T> data(T data, long total) {
        return new DataResponse<>(data, total);
    }

    /**
     * 返回带有total的响应封装
     */
    public <T> DataResponse<T> total(long total) {
        return new DataResponse<>(null, total);
    }

    public Long getUserId() {
        throw new UnsupportedOperationException();
    }

    public UserInfo getUserInfo() {
        throw new UnsupportedOperationException();
    }

    private static final class UnModifyResponse extends BaseResponse {
        public UnModifyResponse(int code, String message) {
            super(code, message);
        }

        @Override
        public final void setCode(int code) {
            throw new UnsupportedOperationException("不允许修改code");
        }

        @Override
        public final void setMessage(String message) {
            throw new UnsupportedOperationException("不允许修改message");
        }
    }
}
