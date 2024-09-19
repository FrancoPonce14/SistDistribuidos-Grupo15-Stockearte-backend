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
    public List<Usuario> findByTiendaId(Long tiendaId);

    @Query(value = "SELECT u FROM Usuario u " +
    "LEFT JOIN u.tienda t " +
    "WHERE (:nombre IS NULL OR :nombre = '' OR LOWER(u.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) " +
    "AND (:codigo IS NULL OR (:codigo = '' OR LOWER(t.codigo) LIKE LOWER(CONCAT('%', :codigo, '%')))) " +
    "AND u.rol = 'ROLE_TIENDA'")
    public Page<Usuario> findAll(@Param("nombre") String nombre, @Param("codigo") String codigo, Pageable pageable);
}
