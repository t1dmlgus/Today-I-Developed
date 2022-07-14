package com.t1dmlgus.ordermvp.common.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends BusinessException{
    public UserNotFoundException() {
        super(ErrorType.USER_NOT_FOUND);
    }
}
