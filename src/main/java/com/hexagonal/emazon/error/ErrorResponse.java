package com.hexagonal.emazon.error;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String field;
    private String error;
}
