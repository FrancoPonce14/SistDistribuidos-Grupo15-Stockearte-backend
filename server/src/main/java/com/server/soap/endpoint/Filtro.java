package com.server.soap.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.server.filtro.CrearFiltroRequest;
import com.server.filtro.CrearFiltroResponse;
import com.server.filtro.EditarFiltroRequest;
import com.server.filtro.EditarFiltroResponse;
import com.server.filtro.TraerFiltrosRequest;
import com.server.filtro.TraerFiltrosResponse;
import com.server.filtro.EliminarFiltroResponse;
import com.server.filtro.EliminarFiltroRequest;
import com.server.soap.service.SPfiltroService;

@Endpoint
public class Filtro {

    private static final String NAMESPACE_URI = "http://www.server.com/filtro";

    @Autowired
    private SPfiltroService filtroService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CrearFiltroRequest")
    @ResponsePayload
    public JAXBElement<CrearFiltroResponse> crearFiltro(@RequestPayload JAXBElement<CrearFiltroRequest> request) {
        CrearFiltroResponse response = filtroService.crearFiltro(request.getValue());
        return new JAXBElement<>(new QName(NAMESPACE_URI, "CrearFiltroResponse"),
                CrearFiltroResponse.class, response);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EliminarFiltroRequest")
    @ResponsePayload
    public JAXBElement<EliminarFiltroResponse> EliminarFiltro(@RequestPayload JAXBElement<EliminarFiltroRequest> request) {
        EliminarFiltroResponse response = filtroService.eliminarFiltro(request.getValue());
        return new JAXBElement<>(new QName(NAMESPACE_URI, "EliminarFiltroResponse"),
                EliminarFiltroResponse.class, response);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EditarFiltroRequest")
    @ResponsePayload
    public JAXBElement<EditarFiltroResponse> editarFilto(@RequestPayload JAXBElement<EditarFiltroRequest> request) {
        EditarFiltroResponse response = filtroService.editarFiltro(request.getValue());
        return new JAXBElement<>(new QName(NAMESPACE_URI, "EditarFiltroResponse"),
                EditarFiltroResponse.class, response);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TraerFiltrosRequest")
    @ResponsePayload
    public JAXBElement<TraerFiltrosResponse> traerFiltros(@RequestPayload JAXBElement<TraerFiltrosRequest> request) {
        TraerFiltrosResponse response = filtroService.traerFiltros(request.getValue());
        return new JAXBElement<>(new QName(NAMESPACE_URI, "TraerFiltrosResponse"),
                TraerFiltrosResponse.class, response);
    }
    
}
