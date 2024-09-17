package com.server.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.server.entities.Tienda;

public interface ITiendaRepository extends JpaRepository<Tienda, Long>{
    
        public Optional<Tienda> findByCodigo(String codigo);

        @Query("SELECT t FROM Tienda t WHERE "
        + "(:codigo IS NULL OR LOWER(t.codigo) LIKE LOWER(CONCAT('%', :codigo, '%'))) AND "
        + "(:habilitado IS NULL OR t.habilitado = :habilitado)")
        public Page<Tienda> findAll(@Param("codigo") String codigo, @Param("habilitado") Boolean habilitado, Pageable pageable);
       
}
