package com.cliente_soap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cliente_soap.service.InformeService;
import com.cliente_soap.wsdl.OrdenesCompraRequest;
import com.cliente_soap.wsdl.OrdenesCompraResponse;

@RestController
@RequestMapping("/api/informes")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class InformeController {

    @Autowired
    private InformeService informeService;

    @PostMapping
    public ResponseEntity<OrdenesCompraResponse> informe(@RequestBody OrdenesCompraRequest request) {
        OrdenesCompraResponse response = informeService.informeOrdenCompra(request);
        return ResponseEntity.ok(response);
    }
    
}
