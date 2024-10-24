package com.cliente_soap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.cliente_soap.service.CatalogoService;
import com.cliente_soap.service.UsuarioService;

@Configuration
public class SoapConfig {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.cliente_soap.wsdl");
        return marshaller;
    }

    @Bean
    public UsuarioService getSoapClientUsuario(Jaxb2Marshaller marshaller){
        UsuarioService soapClient = new UsuarioService();
        soapClient.setDefaultUri("http://localhost:8000/ws");
        soapClient.setMarshaller(marshaller);
        soapClient.setUnmarshaller(marshaller);

        return soapClient;
    }

    @Bean
    public CatalogoService getSoapClientCatalogo(Jaxb2Marshaller marshaller){
        CatalogoService soapClient = new CatalogoService();
        soapClient.setDefaultUri("http://localhost:8000/ws");
        soapClient.setMarshaller(marshaller);
        soapClient.setUnmarshaller(marshaller);

        return soapClient;
    }

}