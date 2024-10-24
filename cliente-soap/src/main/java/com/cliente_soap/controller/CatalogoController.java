package com.cliente_soap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cliente_soap.service.CatalogoService;
import com.cliente_soap.wsdl.AsignarProductoRequest;
import com.cliente_soap.wsdl.AsignarProductoResponse;
import com.cliente_soap.wsdl.CrearCatalogoRequest;
import com.cliente_soap.wsdl.CrearCatalogoResponse;
import com.cliente_soap.wsdl.DesasignarProductoRequest;
import com.cliente_soap.wsdl.DesasignarProductoResponse;
import com.cliente_soap.wsdl.DetalleCatalogoRequest;
import com.cliente_soap.wsdl.DetalleCatalogoResponse;
import com.cliente_soap.wsdl.EditarCatalogoRequest;
import com.cliente_soap.wsdl.EditarCatalogoResponse;
import com.cliente_soap.wsdl.ExportarCatalogoAPDFRequest;
import com.cliente_soap.wsdl.ExportarCatalogoAPDFResponse;
import com.cliente_soap.wsdl.TraerCatalogosRequest;
import com.cliente_soap.wsdl.TraerCatalogosResponse;
import com.cliente_soap.wsdl.TraerProductosAsignadosRequest;
import com.cliente_soap.wsdl.TraerProductosAsignadosResponse;
import com.cliente_soap.wsdl.TraerProductosNoAsignadosRequest;
import com.cliente_soap.wsdl.TraerProductosNoAsignadosResponse;

@RestController
@RequestMapping("/api/catalogos")
public class CatalogoController {

    @Autowired
    private CatalogoService catalogoService;

    @PostMapping("/crear")
    public ResponseEntity<CrearCatalogoResponse> crearCatalogo(@RequestBody CrearCatalogoRequest request) {
        CrearCatalogoResponse response = catalogoService.crearCatalogo(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/editar")
    public ResponseEntity<EditarCatalogoResponse> editarCatalogo(@RequestBody EditarCatalogoRequest request) {
        EditarCatalogoResponse response = catalogoService.editarCatalogo(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/productos/asignados")
    public ResponseEntity<TraerProductosAsignadosResponse> traerProductosAsignados(@RequestBody TraerProductosAsignadosRequest request) {
        TraerProductosAsignadosResponse response = catalogoService.traerProductosAsignados(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/productos/no-asignados")
    public ResponseEntity<TraerProductosNoAsignadosResponse> traerProductosNoAsignados(@RequestBody TraerProductosNoAsignadosRequest request) {
        TraerProductosNoAsignadosResponse response = catalogoService.traerProductosNoAsignados(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/asignar")
    public ResponseEntity<AsignarProductoResponse> asignarProducto(@RequestBody AsignarProductoRequest request) {
        AsignarProductoResponse response = catalogoService.asignarProducto(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/desasignar")
    public ResponseEntity<DesasignarProductoResponse> desasignarProducto(@RequestBody DesasignarProductoRequest request) {
        DesasignarProductoResponse response = catalogoService.desasignarProducto(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/listar")
    public ResponseEntity<TraerCatalogosResponse> traerCatalogos(@RequestBody TraerCatalogosRequest request) {
        TraerCatalogosResponse response = catalogoService.traerCatalogos(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/detalle")
    public ResponseEntity<DetalleCatalogoResponse> detalleCatalogo(@RequestBody DetalleCatalogoRequest request) {
        DetalleCatalogoResponse response = catalogoService.detalleCatalogo(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/exportar/pdf")
    public ResponseEntity<ExportarCatalogoAPDFResponse> exportarCatalogoAPDF(@RequestBody ExportarCatalogoAPDFRequest request) {
        ExportarCatalogoAPDFResponse response = catalogoService.exportarCatalogoAPDF(request);
        return ResponseEntity.ok(response);
    }
}