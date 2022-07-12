package com.t1dmlgus.ordermvp.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorType {

    USER_NOT_FOUND("U001", "유저를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    INVALID_PARAMETER("C001", "요청 값이 올바르지 않습니다.", HttpStatus.BAD_REQUEST);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;
}
