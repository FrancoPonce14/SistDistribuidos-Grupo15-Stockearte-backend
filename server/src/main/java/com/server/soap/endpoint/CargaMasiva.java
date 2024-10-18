package com.server.soap.endpoint;

import com.server.usuario.*;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CargaMasiva {
    
    private static final String NAMESPACE_URI = "http://www.server.com/usuario";


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CargaMasivaUsuariosRequest")
    @ResponsePayload
    public CargaMasivaUsuariosResponse cargaMasiva(@RequestPayload CargaMasivaUsuariosRequest request){
        return null;
    }
    
}
