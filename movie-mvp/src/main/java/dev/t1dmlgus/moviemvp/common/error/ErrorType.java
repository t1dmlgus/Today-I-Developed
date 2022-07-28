package dev.t1dmlgus.moviemvp.common.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


/**
 *
 * class : 예외타입
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * ~ 2022-07-26         이의현        enum(message, HTTP status)
 * 2022-07-26           이의현        enum(message) 변경
 */

@Getter
@RequiredArgsConstructor
public enum ErrorType {

    COMMON_INVALID_PARAMETER( "요청한 값이 올바르지 않습니다."),
    AREA_INVALID_PARAMETER( "요청한 값[area]이 올바르지 않습니다."),
    DATE_INVALID_PARAMETER( "요청한 값[date] 당일 날짜만 가능합니다. ex)20220716"),

    MOVIE_ENTITY_NOT_FOUND( "해당 영화를 찾을 수 없습니다."),
    THEATER_ENTITY_NOT_FOUND( "해당 상영관을 찾을 수 없습니다."),
    SCREEN_ENTITY_NOT_FOUND( "해당 상영을 찾을 수 없습니다."),
    CINEMA_ENTITY_NOT_FOUND( "해당 영화관을 찾을 수 없습니다."),

    DUPLICATED_MOVIE( "이미 존재하는 영화입니다."),
    INTERNAL_SERVER_ERROR("서버 내부 에러");

    private final String message;
}
