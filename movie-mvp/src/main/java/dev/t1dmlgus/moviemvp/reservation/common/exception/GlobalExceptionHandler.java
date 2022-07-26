package dev.t1dmlgus.moviemvp.reservation.common.exception;



import dev.t1dmlgus.moviemvp.reservation.common.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * class : 예외처리 핸들러
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-07-26           이의현        유효성 검증 예외 핸들러
 * 2022-07-26           이의현        BusinessException 예외 핸들러
 *
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidationException(MethodArgumentNotValidException e, HttpServletRequest httpServletRequest) {

        ErrorResponse response = ErrorResponse.of(ErrorType.COMMON_INVALID_PARAMETER, e.getBindingResult(), httpServletRequest);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<Object> BusinessException(BusinessException e, HttpServletRequest httpServletRequest) {

        ErrorResponse response = ErrorResponse.of(e.getErrorType(), httpServletRequest);
        return ResponseEntity.status(e.getHttpStatus()).body(response);
    }
}
