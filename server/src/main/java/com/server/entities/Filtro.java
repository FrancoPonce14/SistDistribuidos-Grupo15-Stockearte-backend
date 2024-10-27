package com.server.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Filtro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String idProducto;
    private String fechaDesde;
    private String fechaHasta;
    private String estadoOrdenCompra;
    private String codigoTienda;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = true)
    @JsonBackReference
    private Usuario usuario;
    
}
