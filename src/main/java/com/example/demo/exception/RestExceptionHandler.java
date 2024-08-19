package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import static org.springframework.http.HttpStatus.CONFLICT;
import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException){
        ApiException apiException = new ApiException(HttpStatus.NOT_FOUND,
                notFoundException.getMessage(), LocalDateTime.now()
                );
        return new ResponseEntity<>(apiException,apiException.getStatus());
    }
    @ExceptionHandler({ConflictException.class})
    protected ResponseEntity<Object> handleConflictException(ConflictException exception){
        ApiException apiException = new ApiException(CONFLICT, exception.getMessage(), LocalDateTime.now());
        return  new ResponseEntity<>(apiException,apiException.getStatus());
    }
    /**
     * خطا را به این صورت برمی گرداند
     */
//    {
//        "status": "NOT_FOUND",
//            "message": "Course Not found.",
//            "timestamp": "2024-08-19T10:27:08.640353"
//    }

}