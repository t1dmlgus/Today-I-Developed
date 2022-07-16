package com.t1dmlgus.ordermvp.common.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Getter
public class CommonResponse<T> {

    @JsonIgnore
    private final HttpStatus statusCode;
    private final String message;
    private final List<T> data;
    private final ResultCode result = ResultCode.SUCCESS;

    @Builder
    public CommonResponse(String message, List<T> data) {
        this.statusCode = HttpStatus.OK;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResponse<T> of(T data, String message){
        return CommonResponse.<T>builder()
                .message(message)
                .data(Collections.singletonList(data))
                .build();
    }

    public static <T> CommonResponse<T> of(String message){
        return CommonResponse.<T>builder()
                .message(message)
                .data(Collections.emptyList())
                .build();
    }
}


