package dev.t1dmlgus.moviemvp.reservation.common.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonResponse<T> {

    @JsonIgnore
    private final HttpStatus statusCode;
    private final String message;
    private final T data;
    private final ResultCode result = ResultCode.SUCCESS;

    @Builder
    public CommonResponse(String message, T data) {
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


