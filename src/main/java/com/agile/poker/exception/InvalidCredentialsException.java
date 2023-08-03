package com.agile.poker.exception;

import com.agile.poker.utils.ErrorCodes;

public class InvalidCredentialsException extends UserInternalException {

    public InvalidCredentialsException() {
        super();
    }

    public InvalidCredentialsException(String message) {
        super(ErrorCodes.INVALID_CREDENTIALS,message);
    }
}
