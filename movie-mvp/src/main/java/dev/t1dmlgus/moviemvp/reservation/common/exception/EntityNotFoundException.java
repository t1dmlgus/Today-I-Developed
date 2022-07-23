package dev.t1dmlgus.moviemvp.reservation.common.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends BusinessException{
    public EntityNotFoundException(ErrorType errorType) {
        super(errorType);
    }
}
