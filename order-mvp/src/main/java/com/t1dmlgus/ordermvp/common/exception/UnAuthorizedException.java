package com.t1dmlgus.ordermvp.common.exception;

public class UnAuthorizedException extends BusinessException {
    public UnAuthorizedException() {
        super(ErrorType.UNAUTHORIZED);
    }
}
