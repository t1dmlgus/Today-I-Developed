package dev.t1dmlgus.moviemvp.common.error.exception;

import dev.t1dmlgus.moviemvp.common.error.ErrorType;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 *
 * class : 서비스 Custom 예외
 * version 1.0
 * ==========================================
 * DATE              DEVELOPER   NOTE
 * ==========================================
 * 2022-07-26        이의현        런타임 시, 발생하는 모든 예외의 부모 클래스
 *                               서비스 내 모든 예외가 BusinessException 상속
 *
 */
@Getter
public class BusinessException extends RuntimeException{

    private final ErrorType errorType;
    private final HttpStatus httpStatus;
    public BusinessException(ErrorType errorType, HttpStatus httpStatus) {
        this.errorType = errorType;
        this.httpStatus = httpStatus;
    }
}
