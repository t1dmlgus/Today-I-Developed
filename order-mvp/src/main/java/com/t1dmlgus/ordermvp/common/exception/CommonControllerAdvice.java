package com.t1dmlgus.ordermvp.common.exception;


import com.t1dmlgus.ordermvp.common.response.ErrorResponse;
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
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<Object> BusinessException(BusinessException e, HttpServletRequest httpServletRequest) {

        ErrorResponse response = ErrorResponse.of(e.getErrorType(), httpServletRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
