package com.cliente_soap.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.cliente_soap.wsdl.OrdenesCompraRequest;
import com.cliente_soap.wsdl.OrdenesCompraResponse;

public class InformeService extends WebServiceGatewaySupport {

    @Value("${soap.url.ws}")
    private String url;
    
    public OrdenesCompraResponse informeOrdenCompra(OrdenesCompraRequest request) {
        return (OrdenesCompraResponse) getWebServiceTemplate().marshalSendAndReceive(url, request, new SoapActionCallback("http://www.server.com/informe/OrdenesCompra"));
    }
    
}
