package com.server.soap.endpoint;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.server.soap.service.SPusuarioService;
import com.server.usuario.CargaMasivaUsuariosRequest;
import com.server.usuario.CargaMasivaUsuariosResponse;

@Endpoint
public class CargaMasiva {

    @Autowired
    private SPusuarioService usuarioService;

    private static final String NAMESPACE_URI = "http://www.server.com/usuario";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CargaMasivaUsuariosRequest")
    @ResponsePayload
    public JAXBElement<CargaMasivaUsuariosResponse> cargaMasiva(@RequestPayload JAXBElement<CargaMasivaUsuariosRequest> request) {
        CargaMasivaUsuariosResponse response = new CargaMasivaUsuariosResponse();

        CargaMasivaUsuariosRequest cargaMasivaRequest = request.getValue();

        List<CargaMasivaUsuariosResponse.Errores> errores = usuarioService.cargarUsuarios(cargaMasivaRequest.getUsuario());

        if (errores.isEmpty()) {
            response.setResultado("Bien");
        } else {
            response.setResultado("Mal");
            for (CargaMasivaUsuariosResponse.Errores error : errores) {
                response.getErrores().add(error);
            }
        }
        return new JAXBElement<>(new QName(NAMESPACE_URI, "CargaMasivaUsuariosResponse"),
                CargaMasivaUsuariosResponse.class,
                response);
    }
}
