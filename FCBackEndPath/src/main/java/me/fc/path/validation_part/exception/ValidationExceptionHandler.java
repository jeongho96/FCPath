//package com.fc.path.fcpath.validation_part.exception;
//
//
//import com.fc.path.fcpath.validation_part.model.Api;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.stream.Collectors;
//
//@Slf4j
//@RestControllerAdvice
//public class ValidationExceptionHandler {
//
//    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
//    public ResponseEntity<Api> validationException(
//            MethodArgumentNotValidException exception
//    ){
//        log.error("", exception);
//        // error가 있는지 확인해서 에러가 있다면
//
//
//            // 에러가 난 필드에서 가져와서 입력값, 이유 등을 리스트로 만듬.
//            var errorMessageList = exception.getFieldErrors().stream()
//                    .map(it -> {
//                        var format = "%s : { %s } 은 %s";
//                        var message = String.format(format, it.getField(), it.getRejectedValue(), it.getDefaultMessage());
//                        return message;
//                    }).collect(Collectors.toList());
//
//            // 이제 그걸 error에 삽입.
//            var error = Api.Error
//                    .builder()
//                    .errorMessage(errorMessageList)
//                    .build();
//
//
//            var errorResponse = Api.builder()
//                    .resultCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
//                    .resultMessage(HttpStatus.BAD_REQUEST.getReasonPhrase())
//                    .error(error)
//                    .build();
//
//
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//}
