package com.movie.expert.models.exceptions;

public class ValidationException extends PlatformException {

    private final Integer errorCode;

    private final String errorMsg;
    public static final Integer ERROR_CODE = 2;

    public ValidationException(String msg) {
        this.errorMsg = msg;
        this.errorCode = ERROR_CODE;
    }

    @Override
    public Integer getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errorMsg;
    }
}
