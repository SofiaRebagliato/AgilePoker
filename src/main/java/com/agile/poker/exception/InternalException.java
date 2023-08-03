package com.agile.poker.exception;

import com.agile.poker.response.InternalExceptionResponse;

public class InternalException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final Integer errorCode;

    public InternalException() {
        super();
        this.errorCode = null;
    }

    public InternalException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public InternalExceptionResponse getResponse() {
        return new InternalExceptionResponse(this.getErrorCode(), this.getMessage());
    }
}