package com.server.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class OrdenCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estado;
    private String observaciones;

    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;

    @ManyToOne
    @JoinColumn(name = "tienda_id")
    private Tienda tienda;

    @OneToOne(mappedBy = "ordenCompra", cascade = CascadeType.ALL)
    private OrdenDespacho ordenDespacho;

    @OneToMany(mappedBy = "ordenCompra", cascade = CascadeType.ALL)
    private List<Item> items;
}
