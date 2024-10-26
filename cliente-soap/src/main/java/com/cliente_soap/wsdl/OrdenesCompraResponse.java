//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.26 a las 07:19:24 PM ART 
//


package com.cliente_soap.wsdl;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="orden" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="nombreProducto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="talle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="codigoTienda" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="resultado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "orden",
    "resultado"
})
@XmlRootElement(name = "OrdenesCompraResponse", namespace = "http://www.server.com/informe")
public class OrdenesCompraResponse {

    @XmlElement(namespace = "http://www.server.com/informe", required = true)
    protected List<OrdenesCompraResponse.Orden> orden;
    @XmlElement(namespace = "http://www.server.com/informe", required = true)
    protected String resultado;

    /**
     * Gets the value of the orden property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orden property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrden().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrdenesCompraResponse.Orden }
     * 
     * 
     */
    public List<OrdenesCompraResponse.Orden> getOrden() {
        if (orden == null) {
            orden = new ArrayList<OrdenesCompraResponse.Orden>();
        }
        return this.orden;
    }

    /**
     * Obtiene el valor de la propiedad resultado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Define el valor de la propiedad resultado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultado(String value) {
        this.resultado = value;
    }


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
     *         &lt;element name="nombreProducto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="talle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="codigoTienda" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
        "nombreProducto",
        "color",
        "talle",
        "codigoTienda",
        "estado",
        "cantidad"
    })
    public static class Orden {

        @XmlElement(namespace = "http://www.server.com/informe", required = true)
        protected String nombreProducto;
        @XmlElement(namespace = "http://www.server.com/informe", required = true)
        protected String color;
        @XmlElement(namespace = "http://www.server.com/informe", required = true)
        protected String talle;
        @XmlElement(namespace = "http://www.server.com/informe", required = true)
        protected String codigoTienda;
        @XmlElement(namespace = "http://www.server.com/informe", required = true)
        protected String estado;
        @XmlElement(namespace = "http://www.server.com/informe")
        protected int cantidad;

        /**
         * Obtiene el valor de la propiedad nombreProducto.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNombreProducto() {
            return nombreProducto;
        }

        /**
         * Define el valor de la propiedad nombreProducto.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNombreProducto(String value) {
            this.nombreProducto = value;
        }

        /**
         * Obtiene el valor de la propiedad color.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getColor() {
            return color;
        }

        /**
         * Define el valor de la propiedad color.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setColor(String value) {
            this.color = value;
        }

        /**
         * Obtiene el valor de la propiedad talle.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTalle() {
            return talle;
        }

        /**
         * Define el valor de la propiedad talle.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTalle(String value) {
            this.talle = value;
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
         * Obtiene el valor de la propiedad cantidad.
         * 
         */
        public int getCantidad() {
            return cantidad;
        }

        /**
         * Define el valor de la propiedad cantidad.
         * 
         */
        public void setCantidad(int value) {
            this.cantidad = value;
        }

    }

}
