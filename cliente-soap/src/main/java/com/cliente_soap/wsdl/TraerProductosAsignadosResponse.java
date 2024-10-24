//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.24 a las 08:05:38 PM ART 
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
 *         &lt;element name="producto" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="idProducto" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *                   &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="talle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="imagen" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
    "producto"
})
@XmlRootElement(name = "TraerProductosAsignadosResponse")
public class TraerProductosAsignadosResponse {

    @XmlElement(required = true)
    protected List<TraerProductosAsignadosResponse.Producto> producto;

    /**
     * Gets the value of the producto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the producto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProducto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TraerProductosAsignadosResponse.Producto }
     * 
     * 
     */
    public List<TraerProductosAsignadosResponse.Producto> getProducto() {
        if (producto == null) {
            producto = new ArrayList<TraerProductosAsignadosResponse.Producto>();
        }
        return this.producto;
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
     *         &lt;element name="idProducto" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
     *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="talle" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="imagen" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
        "idProducto",
        "nombre",
        "talle",
        "color",
        "imagen"
    })
    public static class Producto {

        protected long idProducto;
        @XmlElement(required = true)
        protected String nombre;
        @XmlElement(required = true)
        protected String talle;
        @XmlElement(required = true)
        protected String color;
        @XmlElement(required = true)
        protected String imagen;

        /**
         * Obtiene el valor de la propiedad idProducto.
         * 
         */
        public long getIdProducto() {
            return idProducto;
        }

        /**
         * Define el valor de la propiedad idProducto.
         * 
         */
        public void setIdProducto(long value) {
            this.idProducto = value;
        }

        /**
         * Obtiene el valor de la propiedad nombre.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Define el valor de la propiedad nombre.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNombre(String value) {
            this.nombre = value;
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
         * Obtiene el valor de la propiedad imagen.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getImagen() {
            return imagen;
        }

        /**
         * Define el valor de la propiedad imagen.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setImagen(String value) {
            this.imagen = value;
        }

    }

}
