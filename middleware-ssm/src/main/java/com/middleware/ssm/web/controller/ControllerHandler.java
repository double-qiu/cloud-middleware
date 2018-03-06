package com.middleware.ssm.web.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.middleware.ssm.service.ServiceException;
import com.middleware.ssm.vo.BaseResponse;

@RestControllerAdvice
public class ControllerHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 捕捉异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleException(HttpServletResponse response, Exception e) {
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException me = (MethodArgumentNotValidException) e;
            StringBuilder sb = new StringBuilder();
            List<ObjectError> errors = me.getBindingResult().getAllErrors();
            if (errors.size() > 1) {
                sb.append("共").append(errors.size()).append("个错误：");
            }
            for (ObjectError error : errors) {
                sb.append(error.getDefaultMessage()).append("，");
            }
            sb.delete(sb.length() - 1, sb.length());
            String s = sb.toString();
            logger.info("参数非法：{}", s);
            return new BaseResponse(5, s);
        } else if (e instanceof ServiceException) {
            ServiceException es = (ServiceException) e;
            logger.info("业务异常：code={},message={}", es.getCode(), es.getMessage());
            return new BaseResponse(es.getCode(), es.getMessage());
        } else {
            logger.error("系统异常", e);
            return new BaseResponse(10, "系统异常");
        }
    }
}
