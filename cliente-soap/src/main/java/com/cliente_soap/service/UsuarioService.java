package com.cliente_soap.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.cliente_soap.wsdl.CargaMasivaUsuariosRequest;
import com.cliente_soap.wsdl.CargaMasivaUsuariosResponse;

public class UsuarioService extends WebServiceGatewaySupport {

    @Value("${soap.url.ws}")
    private String url;

    public CargaMasivaUsuariosResponse cargarMasivosUsuarios(CargaMasivaUsuariosRequest request) {
        return (CargaMasivaUsuariosResponse) getWebServiceTemplate().marshalSendAndReceive(url, request, new SoapActionCallback("http://www.server.com/usuario/CargaMasivaUsuarios"));
    }

}
