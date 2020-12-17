package com.less.model.annotations.exception;

public class SelfException extends RuntimeException {
    public SelfException() {
        super();
    }

    public SelfException(String message) {
        super(message);
    }

    public SelfException(String message, Throwable cause) {
        super(message, cause);
    }

    public SelfException(Throwable cause) {
        super(cause);
    }

    protected SelfException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
