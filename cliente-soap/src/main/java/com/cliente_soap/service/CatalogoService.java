package com.cliente_soap.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.cliente_soap.wsdl.AsignarProductoRequest;
import com.cliente_soap.wsdl.AsignarProductoResponse;
import com.cliente_soap.wsdl.CrearCatalogoRequest;
import com.cliente_soap.wsdl.CrearCatalogoResponse;
import com.cliente_soap.wsdl.DesasignarProductoRequest;
import com.cliente_soap.wsdl.DesasignarProductoResponse;
import com.cliente_soap.wsdl.DetalleCatalogoRequest;
import com.cliente_soap.wsdl.DetalleCatalogoResponse;
import com.cliente_soap.wsdl.EditarCatalogoRequest;
import com.cliente_soap.wsdl.EditarCatalogoResponse;
import com.cliente_soap.wsdl.ExportarCatalogoAPDFRequest;
import com.cliente_soap.wsdl.ExportarCatalogoAPDFResponse;
import com.cliente_soap.wsdl.TraerCatalogosRequest;
import com.cliente_soap.wsdl.TraerCatalogosResponse;
import com.cliente_soap.wsdl.TraerProductosAsignadosRequest;
import com.cliente_soap.wsdl.TraerProductosAsignadosResponse;
import com.cliente_soap.wsdl.TraerProductosNoAsignadosRequest;
import com.cliente_soap.wsdl.TraerProductosNoAsignadosResponse;

public class CatalogoService extends WebServiceGatewaySupport {

    @Value("${soap.url.ws}")
    private String url;

    public CrearCatalogoResponse crearCatalogo(CrearCatalogoRequest request) {
        return (CrearCatalogoResponse) getWebServiceTemplate().marshalSendAndReceive(url, request, new SoapActionCallback("http://www.server.com/catalogo/CrearCatalogo"));
    }

    public EditarCatalogoResponse editarCatalogo(EditarCatalogoRequest request) {
        return (EditarCatalogoResponse) getWebServiceTemplate().marshalSendAndReceive(url, request, new SoapActionCallback("http://www.server.com/catalogo/EditarCatalogo"));
    }

    public TraerProductosAsignadosResponse traerProductosAsignados(TraerProductosAsignadosRequest request) {
        return (TraerProductosAsignadosResponse) getWebServiceTemplate().marshalSendAndReceive(url, request, new SoapActionCallback("http://www.server.com/catalogo/TraerProductosAsignados"));
    }

    public TraerProductosNoAsignadosResponse traerProductosNoAsignados(TraerProductosNoAsignadosRequest request) {
        return (TraerProductosNoAsignadosResponse) getWebServiceTemplate().marshalSendAndReceive(url, request, new SoapActionCallback("http://www.server.com/catalogo/TraerProductosNoAsignados"));
    }

    public AsignarProductoResponse asignarProducto(AsignarProductoRequest request) {
        return (AsignarProductoResponse) getWebServiceTemplate().marshalSendAndReceive(url, request, new SoapActionCallback("http://www.server.com/catalogo/AsignarProducto"));
    }

    public DesasignarProductoResponse desasignarProducto(DesasignarProductoRequest request) {
        return (DesasignarProductoResponse) getWebServiceTemplate().marshalSendAndReceive(url, request, new SoapActionCallback("http://www.server.com/catalogo/DesasignarProducto"));
    }

    public TraerCatalogosResponse traerCatalogos(TraerCatalogosRequest request) {
        return (TraerCatalogosResponse) getWebServiceTemplate().marshalSendAndReceive(url, request, new SoapActionCallback("http://www.server.com/catalogo/TraerCatalogos"));
    }

    public DetalleCatalogoResponse detalleCatalogo(DetalleCatalogoRequest request) {
        return (DetalleCatalogoResponse) getWebServiceTemplate().marshalSendAndReceive(url, request, new SoapActionCallback("http://www.server.com/catalogo/DetalleCatalogo"));
    }

    public ExportarCatalogoAPDFResponse exportarCatalogoAPDF(ExportarCatalogoAPDFRequest request) {
        return (ExportarCatalogoAPDFResponse) getWebServiceTemplate().marshalSendAndReceive(url, request, new SoapActionCallback("http://www.server.com/catalogo/ExportarCatalogoAPDF"));
    }

}
