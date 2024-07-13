package org.delivery.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
// ErrorCode에 정의된 메서드들이 Getter 이름이라 이렇게 해줘도 가능.
@Getter
public enum ErrorCode implements ErrorCodeIfs{


    OK(200, 200, "성공"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), 400, "잘못된 요청" ),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), 500, "서버 에러"),
    NULL_POINT(HttpStatus.INTERNAL_SERVER_ERROR.value(), 512, "Null point")
    ;


    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;


}
