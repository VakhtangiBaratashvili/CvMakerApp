package com.example.cvmaker.handler;

import com.example.cvmaker.dto.ApiErrorResponse;
import com.example.cvmaker.exception.CvNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static java.lang.Boolean.FALSE;
import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ApiErrorHandler {

    @ExceptionHandler(CvNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> cvNotFoundExceptionHandler(CvNotFoundException e) {
        ApiErrorResponse response = ApiErrorResponse.
                builder().
                success(FALSE).
                message(e.getMessage()).
                status(NOT_FOUND).
                statusCode(NOT_FOUND.value()).
                build();

        return new ResponseEntity<>(response, NOT_FOUND);
    }
}
