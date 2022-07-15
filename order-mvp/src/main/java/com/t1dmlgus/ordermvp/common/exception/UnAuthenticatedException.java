package com.t1dmlgus.ordermvp.common.exception;

public class UnAuthenticatedException extends BusinessException{
    public UnAuthenticatedException() {
        super(ErrorType.UNAUTHENTICATED);
    }
}
