package com.t1dmlgus.ordermvp.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorType {

    COMMON_INVALID_PARAMETER( "요청한 값이 올바르지 않습니다.", HttpStatus.BAD_REQUEST),

    UNAUTHENTICATED( "로그인이 필요한 서비스입니다.", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED( "접근 권한이 없습니다.", HttpStatus.FORBIDDEN),

    USER_ENTITY_NOT_FOUND( "존재하지 않는 유저입니다.", HttpStatus.NOT_FOUND),
    ITEM_ENTITY_NOT_FOUND( "존재하지 않는 상품입니다.", HttpStatus.NOT_FOUND),
    BAD_CREDENTIALS( " 아이디(로그인 전용 아이디) 또는 비밀번호를 잘못 입력했습니다.", HttpStatus.UNAUTHORIZED),
    DUPLICATED_USERNAME( "현재 사용중인 아이디입니다.", HttpStatus.BAD_REQUEST);

    private final String message;
    private final HttpStatus httpStatus;
}
