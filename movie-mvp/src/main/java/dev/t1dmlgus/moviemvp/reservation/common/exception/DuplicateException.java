package dev.t1dmlgus.moviemvp.reservation.common.exception;

import org.springframework.http.HttpStatus;

/**
 *
 * class : 중복된 리소스 예외
 * version 1.0
 * ==========================================
 * DATE              DEVELOPER   NOTE
 * ==========================================
 * 2022-07-26        이의현        ErrorType (인수)
 *                               400 Bad Request
 *
 */
public class DuplicateException extends BusinessException {

    public DuplicateException(ErrorType errorType) {
        super(errorType, HttpStatus.BAD_REQUEST);
    }

}
