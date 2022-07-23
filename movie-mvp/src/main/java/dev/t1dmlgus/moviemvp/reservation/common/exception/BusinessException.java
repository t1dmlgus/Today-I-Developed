package dev.t1dmlgus.moviemvp.reservation.common.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{

    private final ErrorType errorType;
    public BusinessException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
