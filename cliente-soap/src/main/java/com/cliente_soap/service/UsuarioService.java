package com.cliente_soap.service;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.cliente_soap.wsdl.CargaMasivaUsuariosRequest;
import com.cliente_soap.wsdl.CargaMasivaUsuariosResponse;


public class UsuarioService extends WebServiceGatewaySupport{
    

    public CargaMasivaUsuariosResponse cargarMasivosUsuarios(CargaMasivaUsuariosRequest request) {
        // Llama al servicio SOAP y captura la respuesta
        return (CargaMasivaUsuariosResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8000/ws", request, new SoapActionCallback("http://www.server.com/usuario/CargaMasivaUsuarios"));
    }
    
}
