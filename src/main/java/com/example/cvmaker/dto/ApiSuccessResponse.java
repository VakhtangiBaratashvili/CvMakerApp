package com.example.cvmaker.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ApiSuccessResponse {

    private Boolean success;
    private Object data;
    private HttpStatus status;
    private Integer statusCode;
}
