package com.server.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.server.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
    
    public Optional<Usuario> findByEmail(String email);
    public List<Usuario> findByTiendaIsNull();

    @Query("SELECT u FROM Usuario u WHERE "
    + "(:nombre IS NULL OR LOWER(u.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND "
    + "(:codigo IS NULL OR LOWER(u.tienda.codigo) LIKE LOWER(CONCAT('%', :codigo, '%')))")
    public Page<Usuario> findAll(@Param("nombre") String nombre, @Param("codigo") String codigo, Pageable pageable);
}
