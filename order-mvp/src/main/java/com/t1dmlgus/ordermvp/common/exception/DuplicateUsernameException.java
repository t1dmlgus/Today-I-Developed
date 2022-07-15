package com.t1dmlgus.ordermvp.common.exception;

public class DuplicateUsernameException extends BusinessException{

    public DuplicateUsernameException() {
        super(ErrorType.DUPLICATED_USERNAME);
    }
}
