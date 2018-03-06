package com.middleware.common.exception;

/**
 * 应用异常.
 * <p>
 * Created by DOUBLE on 2017/02/17.
 */
public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 9011929654532518506L;

	public ApplicationException() {
        super();
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
