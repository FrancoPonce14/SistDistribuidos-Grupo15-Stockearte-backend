package com.server.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

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
    private HttpStatusCode estado;

    public ServerException(String mensaje1, String mensaje2, HttpStatus estado) {
        super();
        this.mensaje = mensaje1;
        this.mensaje = mensaje2;
        this.estado = estado;
    }

}