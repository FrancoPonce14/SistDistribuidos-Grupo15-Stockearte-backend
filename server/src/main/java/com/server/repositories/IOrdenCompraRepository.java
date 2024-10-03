package com.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.OrdenCompra;

public interface IOrdenCompraRepository extends JpaRepository<OrdenCompra, Long>{
    
}
