package com.t1dmlgus.ordermvp.common.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends BusinessException{
    public EntityNotFoundException(ErrorType errorType) {
        super(errorType);
    }
}
