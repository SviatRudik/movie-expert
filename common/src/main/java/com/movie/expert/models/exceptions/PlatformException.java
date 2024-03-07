package com.movie.expert.models.exceptions;


public abstract class PlatformException extends RuntimeException {

    abstract public Integer getErrorCode();

    abstract public String getErrorMsg();
}
