package com.server.soap.endpoint;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.lowagie.text.DocumentException;
import com.server.catalogo.AsignarProductoRequest;
import com.server.catalogo.AsignarProductoResponse;
import com.server.catalogo.CrearCatalogoRequest;
import com.server.catalogo.CrearCatalogoResponse;
import com.server.catalogo.DesasignarProductoRequest;
import com.server.catalogo.DesasignarProductoResponse;
import com.server.catalogo.DetalleCatalogoRequest;
import com.server.catalogo.DetalleCatalogoResponse;
import com.server.catalogo.EditarCatalogoRequest;
import com.server.catalogo.EditarCatalogoResponse;
import com.server.catalogo.ExportarCatalogoAPDFRequest;
import com.server.catalogo.ExportarCatalogoAPDFResponse;
import com.server.catalogo.TraerCatalogosRequest;
import com.server.catalogo.TraerCatalogosResponse;
import com.server.catalogo.TraerProductosAsignadosRequest;
import com.server.catalogo.TraerProductosAsignadosResponse;
import com.server.catalogo.TraerProductosNoAsignadosRequest;
import com.server.catalogo.TraerProductosNoAsignadosResponse;
import com.server.soap.service.SPcatalogoService;

@Endpoint
public class Catalogo {

    private static final String NAMESPACE_URI = "http://www.server.com/catalogo";

    @Autowired
    private SPcatalogoService catalogoService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CrearCatalogoRequest")
    @ResponsePayload
    public JAXBElement<CrearCatalogoResponse> crearCatalogo(@RequestPayload JAXBElement<CrearCatalogoRequest> request) {
        CrearCatalogoResponse response = catalogoService.crearCatalogo(request.getValue());
        return new JAXBElement<>(new QName(NAMESPACE_URI, "CrearCatalogoResponse"),
                CrearCatalogoResponse.class, response);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EditarCatalogoRequest")
    @ResponsePayload
    public JAXBElement<EditarCatalogoResponse> editarCatalogo(@RequestPayload JAXBElement<EditarCatalogoRequest> request) {
        EditarCatalogoResponse response = catalogoService.editarCatalogo(request.getValue());
        return new JAXBElement<>(new QName(NAMESPACE_URI, "EditarCatalogoResponse"),
                EditarCatalogoResponse.class, response);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TraerProductosAsignadosRequest")
    @ResponsePayload
    public JAXBElement<TraerProductosAsignadosResponse> traerProductosAsignados(@RequestPayload JAXBElement<TraerProductosAsignadosRequest> request) {
        TraerProductosAsignadosResponse response = catalogoService.traerProductosAsignados(request.getValue());
        return new JAXBElement<>(new QName(NAMESPACE_URI, "TraerProductosAsignadosResponse"),
                TraerProductosAsignadosResponse.class, response);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TraerProductosNoAsignadosRequest")
    @ResponsePayload
    public JAXBElement<TraerProductosNoAsignadosResponse> traerProductosNoAsignados(@RequestPayload JAXBElement<TraerProductosNoAsignadosRequest> request) {
        TraerProductosNoAsignadosResponse response = catalogoService.traerProductosNoAsignados(request.getValue());
        return new JAXBElement<>(new QName(NAMESPACE_URI, "TraerProductosNoAsignadosResponse"),
                TraerProductosNoAsignadosResponse.class, response);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AsignarProductoRequest")
    @ResponsePayload
    public JAXBElement<AsignarProductoResponse> asignarProducto(@RequestPayload JAXBElement<AsignarProductoRequest> request) {
        AsignarProductoResponse response = catalogoService.asignarProducto(request.getValue());
        return new JAXBElement<>(new QName(NAMESPACE_URI, "AsignarProductoResponse"),
                AsignarProductoResponse.class, response);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DesasignarProductoRequest")
    @ResponsePayload
    public JAXBElement<DesasignarProductoResponse> desasignarProducto(@RequestPayload JAXBElement<DesasignarProductoRequest> request) {
        DesasignarProductoResponse response = catalogoService.desasignarProducto(request.getValue());
        return new JAXBElement<>(new QName(NAMESPACE_URI, "DesasignarProductoResponse"),
                DesasignarProductoResponse.class, response);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TraerCatalogosRequest")
    @ResponsePayload
    public JAXBElement<TraerCatalogosResponse> traerCatalogos(@RequestPayload JAXBElement<TraerCatalogosRequest> request) {
        TraerCatalogosResponse response = catalogoService.traerCatalogos(request.getValue());
        return new JAXBElement<>(new QName(NAMESPACE_URI, "TraerCatalogosResponse"),
                TraerCatalogosResponse.class, response);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DetalleCatalogoRequest")
    @ResponsePayload
    public JAXBElement<DetalleCatalogoResponse> detalleCatalogo(@RequestPayload JAXBElement<DetalleCatalogoRequest> request) {
        DetalleCatalogoResponse response = catalogoService.detalleCatalogo(request.getValue());
        return new JAXBElement<>(new QName(NAMESPACE_URI, "DetalleCatalogoResponse"),
                DetalleCatalogoResponse.class, response);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ExportarCatalogoAPDFRequest")
    @ResponsePayload
    public JAXBElement<ExportarCatalogoAPDFResponse> exportarCatalogoAPDF(@RequestPayload JAXBElement<ExportarCatalogoAPDFRequest> request, HttpServletResponse responsePDF) throws DocumentException, IOException {
        ExportarCatalogoAPDFResponse response = catalogoService.exportarCatalogoAPDF(request.getValue(), responsePDF);
        return new JAXBElement<>(new QName(NAMESPACE_URI, "ExportarCatalogoAPDFResponse"),
                ExportarCatalogoAPDFResponse.class, response);
    }

}
