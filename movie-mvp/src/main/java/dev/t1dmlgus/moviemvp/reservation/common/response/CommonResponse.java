package dev.t1dmlgus.moviemvp.reservation.common.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 *
 * class : 공통 응답 DTO
 * version 1.0
 * ==========================================
 * DATE              DEVELOPER   NOTE
 * ==========================================
 * 2022-07-26        이의현        HTTP 상태코드, 응답 메시지, 응답 데이터, API 성공 유무
 *                               제네릭 타입의 응답데이터
 *
 *
 *
 */

@Getter
public class CommonResponse<T> {

    @JsonIgnore
    private final HttpStatus statusCode;
    private final String message;
    private final T data;
    private final ResultCode result = ResultCode.SUCCESS;

    @Builder
    private CommonResponse(String message, T data) {
        this.statusCode = HttpStatus.OK;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResponse<T> of(T data, String message){
        return CommonResponse.<T>builder()
                .message(message)
                .data(data)
                .build();
    }

    public static <T> CommonResponse<T> of(String message){
        return CommonResponse.<T>builder()
                .message(message)
                .build();
    }
}


