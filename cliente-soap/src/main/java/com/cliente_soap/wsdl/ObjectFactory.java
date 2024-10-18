//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.18 a las 08:07:00 PM ART 
//


package com.cliente_soap.wsdl;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cliente_soap.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cliente_soap.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CargaMasivaUsuariosRequest }
     * 
     */
    public CargaMasivaUsuariosRequest createCargaMasivaUsuariosRequest() {
        return new CargaMasivaUsuariosRequest();
    }

    /**
     * Create an instance of {@link CargaMasivaUsuariosResponse }
     * 
     */
    public CargaMasivaUsuariosResponse createCargaMasivaUsuariosResponse() {
        return new CargaMasivaUsuariosResponse();
    }

    /**
     * Create an instance of {@link CargaMasivaUsuariosRequest.Usuario }
     * 
     */
    public CargaMasivaUsuariosRequest.Usuario createCargaMasivaUsuariosRequestUsuario() {
        return new CargaMasivaUsuariosRequest.Usuario();
    }

    /**
     * Create an instance of {@link CargaMasivaUsuariosResponse.Errores }
     * 
     */
    public CargaMasivaUsuariosResponse.Errores createCargaMasivaUsuariosResponseErrores() {
        return new CargaMasivaUsuariosResponse.Errores();
    }

    /**
     * Create an instance of {@link UsuarioSoap }
     * 
     */
    public UsuarioSoap createUsuarioSoap() {
        return new UsuarioSoap();
    }

}
