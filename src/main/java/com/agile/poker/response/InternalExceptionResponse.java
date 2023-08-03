package com.agile.poker.response;

public class InternalExceptionResponse {

    private InternalExceptionResponseBody error;

    public class InternalExceptionResponseBody {
        private Integer errorCode;
        private String message;

        public InternalExceptionResponseBody(Integer errorCode, String message) {
            this.errorCode = errorCode;
            this.message = message;
        }

        public Integer getErrorCode() {
            return errorCode;
        }

        public String getMessage() {
            return message;
        }
    }

    public InternalExceptionResponse(Integer errorCode, String message) {
        this.error = new InternalExceptionResponseBody(errorCode, message);
    }

    public InternalExceptionResponseBody getError() {
        return error;
    }
}
