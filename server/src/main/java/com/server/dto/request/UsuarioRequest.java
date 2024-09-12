package com.server.dto.request;

import lombok.Data;

@Data
public class UsuarioRequest {
    private String nombre;
    private String email;
    private String clave;
    private String rol;
    private boolean habilitado;
}
