package com.example.ecommerce.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponseMessage {


    private String message;

    private boolean success;

    private HttpStatus status;
}