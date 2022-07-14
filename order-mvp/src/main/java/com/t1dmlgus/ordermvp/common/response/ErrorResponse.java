package com.t1dmlgus.ordermvp.common.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.t1dmlgus.ordermvp.common.exception.ErrorType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
public class ErrorResponse {

    @JsonIgnore
    private final HttpStatus statusCode;
    private final String requestUrl;
    private final String errorCode;
    private final String errorMessage;
    private final ResultCode result;

    private final List<ErrorField> errorFields;

    @Builder
    public ErrorResponse(HttpStatus statusCode, String requestUrl, String errorCode, String errorMessage, ResultCode resultCode, List<ErrorField> errorFields) {
        this.statusCode = statusCode;
        this.requestUrl = requestUrl;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.result = ResultCode.FAIL;
        this.errorFields = errorFields;
    }

    public static ErrorResponse of(ErrorType errorType, BindingResult bindingResult, HttpServletRequest httpServletRequest){

        return ErrorResponse.builder()
                .statusCode(errorType.getHttpStatus())
                .requestUrl(httpServletRequest.getRequestURI())
                .errorCode(errorType.getCode())
                .errorMessage(errorType.getMessage())
                .errorFields(ErrorField.of(bindingResult))
                .build();
    }

    public static ErrorResponse of(ErrorType errorType, HttpServletRequest httpServletRequest){

        return ErrorResponse.builder()
                .requestUrl(httpServletRequest.getRequestURI())
                .statusCode(errorType.getHttpStatus())
                .errorCode(errorType.getCode())
                .errorMessage(errorType.getMessage())
                .errorFields(new ArrayList<>())
                .build();
    }

    @Getter
    public static class ErrorField {

        private final String field;
        private final String message;
        private final String invalidValue;


        @Builder
        private ErrorField(String field, String message, String invalidValue) {
            this.field = field;
            this.message = message;
            this.invalidValue = invalidValue;
        }

        private static List<ErrorField> of(BindingResult bindingResult) {

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            return fieldErrors.stream()
                    .map(i-> ErrorField.builder()
                            .field(i.getField())
                            .message(i.getDefaultMessage())
                            .invalidValue(Objects.requireNonNull(i.getRejectedValue()).toString()).build())
                    .collect(Collectors.toList());
        }
    }

}
