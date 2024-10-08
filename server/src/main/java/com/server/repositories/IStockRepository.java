package com.server.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.Stock;
import com.server.entities.Tienda;
import com.server.entities.Producto;

public interface IStockRepository extends JpaRepository<Stock, Long> {

    public Optional<Stock> findByTiendaAndProducto(Tienda tienda, Producto producto);
    
}
