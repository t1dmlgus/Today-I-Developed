package com.t1dmlgus.ordermvp.common.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class CommonControllerAdvice {


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidationException(MethodArgumentNotValidException e, HttpServletRequest httpServletRequest) {

        ErrorResponse response = ErrorResponse.of(ErrorType.INVALID_PARAMETER, e.getBindingResult(), httpServletRequest);
        return ResponseEntity.status(ErrorType.INVALID_PARAMETER.getHttpStatus()).body(response);
    }
}
