package dev.t1dmlgus.moviemvp.reservation.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 *
 * class : 존재하지 않는 리소스 예외
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-07-26           이의현        404 Not Found
 *                                  ErrorType(인수)
 *
 */

@Getter
public class EntityNotFoundException extends BusinessException{
    public EntityNotFoundException(ErrorType errorType) {
        super(errorType, HttpStatus.NOT_FOUND);
    }
}
