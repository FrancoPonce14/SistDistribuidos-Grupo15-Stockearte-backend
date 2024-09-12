package com.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.Tienda;

public interface ITiendaRepository extends JpaRepository<Tienda, Long>{
    
}
