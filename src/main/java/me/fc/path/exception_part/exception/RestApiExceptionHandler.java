package me.fc.path.exception_part.exception;



import lombok.extern.slf4j.Slf4j;
import me.fc.path.exception_part.model.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

@Slf4j
//@RestControllerAdvice
// 예외처리 순서 정할 수 있음.
// 최대값일수록 최후에 수행됨. 디폴트가 INT 최대값.
//@Order(value = 1)
public class RestApiExceptionHandler {

//    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Api> exception(
            Exception e
    ){
        log.error(e.getMessage());


        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .resultMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }


//    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Api> noSuchElement(
            NoSuchElementException e
    ){
        log.error(e.getMessage());


        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();


        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
