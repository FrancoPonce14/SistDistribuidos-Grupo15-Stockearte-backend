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
 *         &lt;element name="resultado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="errores" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="linea" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="mensajeError" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "resultado",
    "errores"
})
@XmlRootElement(name = "CargaMasivaUsuariosResponse")
public class CargaMasivaUsuariosResponse {

    @XmlElement(required = true)
    protected String resultado;
    protected List<CargaMasivaUsuariosResponse.Errores> errores;

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
     * Gets the value of the errores property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errores property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrores().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CargaMasivaUsuariosResponse.Errores }
     * 
     * 
     */
    public List<CargaMasivaUsuariosResponse.Errores> getErrores() {
        if (errores == null) {
            errores = new ArrayList<CargaMasivaUsuariosResponse.Errores>();
        }
        return this.errores;
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
     *         &lt;element name="linea" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="mensajeError" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
        "linea",
        "mensajeError"
    })
    public static class Errores {

        protected int linea;
        @XmlElement(required = true)
        protected String mensajeError;

        /**
         * Obtiene el valor de la propiedad linea.
         * 
         */
        public int getLinea() {
            return linea;
        }

        /**
         * Define el valor de la propiedad linea.
         * 
         */
        public void setLinea(int value) {
            this.linea = value;
        }

        /**
         * Obtiene el valor de la propiedad mensajeError.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMensajeError() {
            return mensajeError;
        }

        /**
         * Define el valor de la propiedad mensajeError.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMensajeError(String value) {
            this.mensajeError = value;
        }

    }

}
