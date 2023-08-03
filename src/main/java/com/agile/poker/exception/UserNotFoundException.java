package com.agile.poker.exception;

import com.agile.poker.utils.ErrorCodes;

public class UserNotFoundException extends UserInternalException {

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(ErrorCodes.USER_NOT_FOUND, message);
    }
}
