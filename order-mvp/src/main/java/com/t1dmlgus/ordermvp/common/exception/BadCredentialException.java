package com.t1dmlgus.ordermvp.common.exception;

public class BadCredentialException extends BusinessException{

    public BadCredentialException() {
        super(ErrorType.BAD_CREDENTIALS);
    }
}
