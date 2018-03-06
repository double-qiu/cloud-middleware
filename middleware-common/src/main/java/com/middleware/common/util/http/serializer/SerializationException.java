package com.middleware.common.util.http.serializer;

public class SerializationException extends RuntimeException {

	private static final long serialVersionUID = -710408872092192490L;

	public SerializationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public SerializationException(String msg) {
        super(msg);
    }
}
