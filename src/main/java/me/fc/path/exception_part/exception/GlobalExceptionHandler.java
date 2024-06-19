package me.fc.path.exception_part.exception;



import lombok.extern.slf4j.Slf4j;
import me.fc.path.exception_part.model.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
//@RestControllerAdvice
public class GlobalExceptionHandler {


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
}
