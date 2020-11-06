package com.soaint.prueba.venta.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {

    private String httpStatus;
    private String message;
    private int code;
    private String backendMessage;
}
