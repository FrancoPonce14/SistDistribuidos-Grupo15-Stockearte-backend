package com.server.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServerException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String mensaje;
    private HttpStatus estado;

}