package com.movie.expert.models.exceptions;

import lombok.Getter;

public class ValidationException extends PlatformException{
    @Getter
    private final Integer errorCode;
    @Getter
    private final String errorMsg;
    public static final int ERROR_CODE = 2;

    public ValidationException(String msg) {
        this.errorMsg = msg;
        this.errorCode = ERROR_CODE;
    }

    @Override
    public Integer errorCode() {
        return this.errorCode;
    }

    @Override
    public String errorMsg() {
        return this.getMessage();
    }
}
