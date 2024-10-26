package com.server.soap.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.server.informe.OrdenesCompraRequest;
import com.server.informe.OrdenesCompraResponse;
import com.server.soap.service.SPinformeService;

@Endpoint
public class Informe {
    
    private static final String NAMESPACE_URI = "http://www.server.com/informe";

    @Autowired
    private SPinformeService informeService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "OrdenesCompraRequest")
    @ResponsePayload
    public JAXBElement<OrdenesCompraResponse> informeOrdenesCompra(@RequestPayload JAXBElement<OrdenesCompraRequest> request) {
        OrdenesCompraResponse response = informeService.informeOrdenesCompra(request.getValue());
        return new JAXBElement<>(new QName(NAMESPACE_URI, "OrdenesCompraResponse"),
                OrdenesCompraResponse.class, response);
    }
}
