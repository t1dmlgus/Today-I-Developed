package dev.t1dmlgus.moviemvp.reservation.common.response;

import dev.t1dmlgus.moviemvp.reservation.common.exception.ErrorType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * class : 에러 응답 DTO
 * version 1.0
 * ==========================================
 * DATE              DEVELOPER   NOTE
 * ==========================================
 * 2022-07-26        이의현        자원의 위치, 에러타입, 에러 메시지, API 성공 유무, 에러 필드(선택)
 * 2022-07-26        이의현        요청 시 유효성 검증을 실패한 에러필드 인스턴스 생성
 *
 *
 */
@Getter
public class ErrorResponse {

    private final String requestUri;
    private final String errorCode;
    private final String errorMessage;
    private final ResultCode result = ResultCode.FAIL;

    private final List<ErrorField> errorFields;

    @Builder
    private ErrorResponse(String requestUri, String errorCode, String errorMessage, List<ErrorField> errorFields) {
        this.requestUri = requestUri;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorFields = errorFields;
    }

    public static ErrorResponse of(ErrorType errorType, BindingResult bindingResult, HttpServletRequest httpServletRequest){

        return ErrorResponse.builder()
                .requestUri(httpServletRequest.getRequestURI())
                .errorCode(errorType.name())
                .errorMessage(errorType.getMessage())
                .errorFields(ErrorField.of(bindingResult))
                .build();
    }

    public static ErrorResponse of(ErrorType errorType, HttpServletRequest httpServletRequest){

        return ErrorResponse.builder()
                .requestUri(httpServletRequest.getRequestURI())
                .errorCode(errorType.name())
                .errorMessage(errorType.getMessage())
                .build();
    }


    @Getter
    private static class ErrorField {

        private final String field;
        private final String message;

        @Builder
        private ErrorField(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public static ErrorField newInstance(String field, String message) {
            return ErrorField.builder()
                    .field(field)
                    .message(message)
                    .build();
        }


        private static List<ErrorField> of(BindingResult bindingResult) {

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            return fieldErrors.stream()
                    .map(i -> ErrorField.newInstance(i.getField(), i.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
    }
}
