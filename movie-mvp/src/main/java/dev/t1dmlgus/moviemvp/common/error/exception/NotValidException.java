package dev.t1dmlgus.moviemvp.common.error.exception;

import dev.t1dmlgus.moviemvp.common.error.ErrorType;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 *
 * class : 유효하지 않은 요청 예외
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-07-26           이의현       400 Bad Request
 *                                 ErrorType(인수)
 *
 */

@Getter
public class NotValidException extends BusinessException{

    public NotValidException(ErrorType errorType) {
        super(errorType, HttpStatus.BAD_REQUEST);
    }
}
