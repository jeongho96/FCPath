package me.fc.fcbackendpath.restapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
// restController를 쓰는 곳에 예외 발생 시 감지.
@RestControllerAdvice(basePackages = "com.fc.fcbackendpath.restapi.controller")
public class RestApiExceptionHandler {


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity exception(
        Exception e
    ){
        log.error("RestApiExceptionHandler", e);

        return ResponseEntity.status(200).build();
    }


    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException e
    ){
        log.error("RestApiExceptionHandler", e);
        return ResponseEntity.status(200).build();
    }
}
