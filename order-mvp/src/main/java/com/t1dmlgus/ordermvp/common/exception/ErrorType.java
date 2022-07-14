package com.t1dmlgus.ordermvp.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorType {

    INVALID_PARAMETER("C001", "요청 값이 올바르지 않습니다.", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND("U001", "유저를 조회할 수 없습니다.", HttpStatus.NOT_FOUND),
    BAD_CREDENTIALS("U002", " 아이디(로그인 전용 아이디) 또는 비밀번호를 잘못 입력했습니다.", HttpStatus.UNAUTHORIZED),
    DUPLICATED_USERNAME("U003", "현재 사용중인 아이디입니다.", HttpStatus.BAD_REQUEST);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;
}
