package com.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.Stock;

public interface IStockRepository extends JpaRepository<Stock, Long> {
    
}
