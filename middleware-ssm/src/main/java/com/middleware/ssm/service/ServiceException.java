package com.middleware.ssm.service;

/**
 * 服务异常
 */
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = -2344261907570896224L;
	private final int code;
    private final String message;

    public ServiceException() {
        this(6, "服务异常");
    }

    public ServiceException(String message) {
        this(6, message);
    }

    public ServiceException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
