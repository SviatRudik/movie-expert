package com.movie.expert.models.exceptions;

import lombok.Getter;

public class UniquenessException extends PlatformException {
    @Getter
    private final Integer errorCode;
    @Getter
    private final String errorMsg;
    public static final int ERROR_CODE = 1;

    public UniquenessException(String msg) {
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
