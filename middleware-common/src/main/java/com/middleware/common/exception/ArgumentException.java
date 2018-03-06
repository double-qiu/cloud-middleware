package com.middleware.common.exception;

/**
 * Created by liangliang on 2017/05/05.
 *
 * @author DOUBLE
 * @since 2017/05/05
 */
public class ArgumentException extends java.lang.IllegalArgumentException {

	private static final long serialVersionUID = -5024835173675671095L;
	protected ErrorCode errorCode;

    public ArgumentException(ErrorCode errorCode) {
        super(formatMsg(errorCode));
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final static String formatMsg(ErrorCode errorCode) {
        return String.format("%s:%s", errorCode.getCode(), errorCode.getMessage());
    }
}
