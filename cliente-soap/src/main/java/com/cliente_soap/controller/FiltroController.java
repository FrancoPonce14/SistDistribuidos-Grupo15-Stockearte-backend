package com.cliente_soap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cliente_soap.service.FiltroService;
import com.cliente_soap.wsdl.CrearFiltroRequest;
import com.cliente_soap.wsdl.CrearFiltroResponse;
import com.cliente_soap.wsdl.EditarFiltroRequest;
import com.cliente_soap.wsdl.EditarFiltroResponse;
import com.cliente_soap.wsdl.TraerFiltrosRequest;
import com.cliente_soap.wsdl.TraerFiltrosResponse;
import com.cliente_soap.wsdl.EliminarFiltroRequest;
import com.cliente_soap.wsdl.EliminarFiltroResponse;

@RestController
@RequestMapping("/api/filtros")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class FiltroController {

    @Autowired
    private FiltroService filtroService;

    @PostMapping("/crear")
    public ResponseEntity<CrearFiltroResponse> crearFiltro(@RequestBody CrearFiltroRequest request) {
        CrearFiltroResponse response = filtroService.crearFiltro(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/eliminar")
    public ResponseEntity<EliminarFiltroResponse> eliminarFiltro(@RequestBody EliminarFiltroRequest request) {
        EliminarFiltroResponse response = filtroService.eliminarFiltro(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/editar")
    public ResponseEntity<EditarFiltroResponse> editarFiltro(@RequestBody EditarFiltroRequest request) {
        EditarFiltroResponse response = filtroService.editarFiltro(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/listar")
    public ResponseEntity<TraerFiltrosResponse> traerFiltros(@RequestBody TraerFiltrosRequest request) {
        TraerFiltrosResponse response = filtroService.traerFiltros(request);
        return ResponseEntity.ok(response);
    }
    
}
