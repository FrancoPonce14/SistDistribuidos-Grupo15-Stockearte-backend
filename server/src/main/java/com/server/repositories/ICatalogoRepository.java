package com.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.Catalogo;

public interface ICatalogoRepository extends JpaRepository<Catalogo, Long>{
    
}
