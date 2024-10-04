package com.server.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.OrdenCompra;

public interface IOrdenCompraRepository extends JpaRepository<OrdenCompra, Long>{
    public List<OrdenCompra> findByTiendaId(Long idTienda);
}
