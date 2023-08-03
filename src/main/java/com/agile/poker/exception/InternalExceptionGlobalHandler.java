package com.agile.poker.exception;

import com.agile.poker.response.InternalExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class InternalExceptionGlobalHandler {

    @ExceptionHandler(InternalException.class)
    public ResponseEntity<InternalExceptionResponse> handleInternalExceptionException(InternalException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getResponse());
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<InternalExceptionResponse> handleInvalidCredentialsException(InvalidCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getResponse());
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<InternalExceptionResponse> handleUserNotFoundExceptionException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getResponse());
    }
}
