package com.server.dto.response;

import lombok.Data;

@Data
public class UsuarioResponse {
    private String nombre;
    private TiendaResponse tienda;
    private boolean habilitado;
}
