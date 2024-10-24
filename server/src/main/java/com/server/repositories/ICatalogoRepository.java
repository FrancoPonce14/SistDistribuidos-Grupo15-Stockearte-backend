package com.server.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.Catalogo;
import com.server.entities.Tienda;

public interface ICatalogoRepository extends JpaRepository<Catalogo, Long>{
    public List<Catalogo> findByTienda(Tienda tienda);
}
