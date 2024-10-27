//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.27 a las 01:57:47 AM ART 
//


package com.cliente_soap.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idFiltro" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="nombreFiltro" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idProducto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechaDesde" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechaHasta" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codigoTienda" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idFiltro",
    "nombreFiltro",
    "idProducto",
    "fechaDesde",
    "fechaHasta",
    "estado",
    "codigoTienda"
})
@XmlRootElement(name = "EditarFiltroRequest", namespace = "http://www.server.com/filtro")
public class EditarFiltroRequest {

    @XmlElement(namespace = "http://www.server.com/filtro")
    protected long idFiltro;
    @XmlElement(namespace = "http://www.server.com/filtro", required = true)
    protected String nombreFiltro;
    @XmlElement(namespace = "http://www.server.com/filtro", required = true)
    protected String idProducto;
    @XmlElement(namespace = "http://www.server.com/filtro", required = true)
    protected String fechaDesde;
    @XmlElement(namespace = "http://www.server.com/filtro", required = true)
    protected String fechaHasta;
    @XmlElement(namespace = "http://www.server.com/filtro", required = true)
    protected String estado;
    @XmlElement(namespace = "http://www.server.com/filtro", required = true)
    protected String codigoTienda;

    /**
     * Obtiene el valor de la propiedad idFiltro.
     * 
     */
    public long getIdFiltro() {
        return idFiltro;
    }

    /**
     * Define el valor de la propiedad idFiltro.
     * 
     */
    public void setIdFiltro(long value) {
        this.idFiltro = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreFiltro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreFiltro() {
        return nombreFiltro;
    }

    /**
     * Define el valor de la propiedad nombreFiltro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreFiltro(String value) {
        this.nombreFiltro = value;
    }

    /**
     * Obtiene el valor de la propiedad idProducto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProducto() {
        return idProducto;
    }

    /**
     * Define el valor de la propiedad idProducto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProducto(String value) {
        this.idProducto = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDesde.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaDesde() {
        return fechaDesde;
    }

    /**
     * Define el valor de la propiedad fechaDesde.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaDesde(String value) {
        this.fechaDesde = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHasta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaHasta() {
        return fechaHasta;
    }

    /**
     * Define el valor de la propiedad fechaHasta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaHasta(String value) {
        this.fechaHasta = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoTienda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoTienda() {
        return codigoTienda;
    }

    /**
     * Define el valor de la propiedad codigoTienda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoTienda(String value) {
        this.codigoTienda = value;
    }

}
