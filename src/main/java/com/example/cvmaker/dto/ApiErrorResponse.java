package com.example.cvmaker.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Builder
@Data
public class ApiErrorResponse {

    private Boolean success;
    private String message;
    private HttpStatus status;
    private Integer statusCode;
    @Builder.Default
    private LocalDateTime timeStamp = LocalDateTime.now();
}
