package com.movie.expert.models.exceptions;

public abstract class PlatformException  extends RuntimeException{
    abstract Integer errorCode();
    abstract String errorMsg();
}
