package com.server.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String nombre;
    private String talle;
    private String color;
    private String imagen;
    private boolean habilitado;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Stock> stock;

    @ManyToMany(mappedBy = "productos", fetch = FetchType.EAGER)
    private List<Catalogo> catalogos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return id != null && id.equals(producto.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode() + (id == null ? 0 : id.hashCode());
    }

}
