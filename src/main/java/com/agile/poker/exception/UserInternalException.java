package com.agile.poker.exception;

public class UserInternalException extends InternalException {

    public UserInternalException() {
        super();
    }

    public UserInternalException(Integer errorCode, String message) {
        super(errorCode, message);
    }
}
