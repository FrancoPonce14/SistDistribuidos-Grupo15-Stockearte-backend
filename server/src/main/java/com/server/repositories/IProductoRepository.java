package com.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
    
}
