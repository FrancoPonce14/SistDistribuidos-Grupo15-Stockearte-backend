package com.cliente_soap.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.cliente_soap.wsdl.CrearFiltroRequest;
import com.cliente_soap.wsdl.CrearFiltroResponse;
import com.cliente_soap.wsdl.EditarFiltroRequest;
import com.cliente_soap.wsdl.EditarFiltroResponse;
import com.cliente_soap.wsdl.TraerFiltrosRequest;
import com.cliente_soap.wsdl.TraerFiltrosResponse;

public class FiltroService extends WebServiceGatewaySupport {

    @Value("${soap.url.ws}")
    private String url;

    public CrearFiltroResponse crearFiltro(CrearFiltroRequest request) {
        return (CrearFiltroResponse) getWebServiceTemplate().marshalSendAndReceive(url, request, new SoapActionCallback("http://www.server.com/filtro/CrearFiltro"));
    }

    public EditarFiltroResponse editarFiltro(EditarFiltroRequest request) {
        return (EditarFiltroResponse) getWebServiceTemplate().marshalSendAndReceive(url, request, new SoapActionCallback("http://www.server.com/filtro/EditarFiltro"));
    }

    public TraerFiltrosResponse traerFiltros(TraerFiltrosRequest request) {
        return (TraerFiltrosResponse) getWebServiceTemplate().marshalSendAndReceive(url, request, new SoapActionCallback("http://www.server.com/filtro/TraerFiltros"));
    }
    
}
