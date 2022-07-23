package dev.t1dmlgus.moviemvp.reservation.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorType {

    COMMON_INVALID_PARAMETER( "요청한 값이 올바르지 않습니다.", HttpStatus.BAD_REQUEST),
    MOVIE_ENTITY_NOT_FOUND( "존재하지 않는 영화입니다.", HttpStatus.NOT_FOUND),

    DUPLICATED_MOVIE( "현재 등록된 영화입니다.", HttpStatus.BAD_REQUEST);

    private final String message;
    private final HttpStatus httpStatus;
}
