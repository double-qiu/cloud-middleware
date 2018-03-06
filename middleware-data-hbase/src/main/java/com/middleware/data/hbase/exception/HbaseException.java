package com.middleware.data.hbase.exception;

import org.springframework.dao.UncategorizedDataAccessException;

/**
 * Created by DOUBLE on 2017/04/10.
 *
 * @author DOUBLE
 * @since 2017/04/10
 */
public class HbaseException extends UncategorizedDataAccessException {

	private static final long serialVersionUID = 4693466153368565298L;

	public HbaseException(Exception cause) {
        super(cause.getMessage(), cause);
    }

    public HbaseException(Throwable throwable) {
        super(throwable.getMessage(), throwable);
    }
}
