package com.server.dto.response;

import lombok.Data;

@Data
public class UsuarioDetalleResponse {
    private Long id;
    private String nombre;
    private String email;
    private String rol;
    private boolean habilitado;
}
