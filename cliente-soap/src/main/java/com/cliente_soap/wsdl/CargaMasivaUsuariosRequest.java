//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.18 a las 08:07:00 PM ART 
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
 *         &lt;element name="usuario" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="clave" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="apellido" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="codigoTienda" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "usuario"
})
@XmlRootElement(name = "CargaMasivaUsuariosRequest")
public class CargaMasivaUsuariosRequest {

    @XmlElement(required = true)
    protected List<CargaMasivaUsuariosRequest.Usuario> usuario;

    /**
     * Gets the value of the usuario property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usuario property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsuario().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CargaMasivaUsuariosRequest.Usuario }
     * 
     * 
     */
    public List<CargaMasivaUsuariosRequest.Usuario> getUsuario() {
        if (usuario == null) {
            usuario = new ArrayList<CargaMasivaUsuariosRequest.Usuario>();
        }
        return this.usuario;
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
     *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="clave" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="apellido" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
        "email",
        "clave",
        "nombre",
        "apellido",
        "codigoTienda"
    })
    public static class Usuario {

        @XmlElement(required = true)
        protected String email;
        @XmlElement(required = true)
        protected String clave;
        @XmlElement(required = true)
        protected String nombre;
        @XmlElement(required = true)
        protected String apellido;
        @XmlElement(required = true)
        protected String codigoTienda;

        /**
         * Obtiene el valor de la propiedad email.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEmail() {
            return email;
        }

        /**
         * Define el valor de la propiedad email.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEmail(String value) {
            this.email = value;
        }

        /**
         * Obtiene el valor de la propiedad clave.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getClave() {
            return clave;
        }

        /**
         * Define el valor de la propiedad clave.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setClave(String value) {
            this.clave = value;
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
         * Obtiene el valor de la propiedad apellido.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApellido() {
            return apellido;
        }

        /**
         * Define el valor de la propiedad apellido.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApellido(String value) {
            this.apellido = value;
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

}
