package com.cliente_soap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cliente_soap.service.UsuarioService;
import com.cliente_soap.wsdl.CargaMasivaUsuariosRequest;
import com.cliente_soap.wsdl.CargaMasivaUsuariosResponse;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/carga-masiva")
    public ResponseEntity<CargaMasivaUsuariosResponse> cargarMasivosUsuarios(@RequestBody CargaMasivaUsuariosRequest request) {
        CargaMasivaUsuariosResponse response = usuarioService.cargarMasivosUsuarios(request);
        return ResponseEntity.ok(response);
    }
    
}
