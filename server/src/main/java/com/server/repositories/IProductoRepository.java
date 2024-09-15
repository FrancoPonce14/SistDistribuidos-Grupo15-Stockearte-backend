package com.server.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.server.entities.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long> {

    public Optional<Producto> findByCodigo(String codigo);    
    @Query(value = "SELECT p.* FROM Producto p JOIN Stock s ON s.producto_id = p.id WHERE s.tienda_id = :tiendaId", nativeQuery = true)
    public List<Producto> findByTienda(@Param("tiendaId") Long tiendaId);
    

    @Query(value = "SELECT p.* FROM producto p JOIN stock s ON p.id = s.producto_id WHERE s.tienda_id = :tiendaId AND "
        + "(:nombre IS NULL OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND "
        + "(:codigo IS NULL OR LOWER(p.codigo) LIKE LOWER(CONCAT('%', :codigo, '%'))) AND "
        + "(:talle IS NULL OR LOWER(p.talle) LIKE LOWER(CONCAT('%', :talle, '%'))) AND "
        + "(:color IS NULL OR LOWER(p.color) LIKE LOWER(CONCAT('%', :color, '%')))", nativeQuery = true)
    public Page<Producto> findByTienda(@Param("tiendaId") Long tiendaId, @Param("nombre") String nombre, @Param("codigo") String codigo, @Param("talle") String talle, @Param("color") String color, Pageable pageable);

    @Query(value = "SELECT * FROM producto p WHERE "
    + "(:nombre IS NULL OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND "
    + "(:codigo IS NULL OR LOWER(p.codigo) LIKE LOWER(CONCAT('%', :codigo, '%'))) AND "
    + "(:talle IS NULL OR LOWER(p.talle) LIKE LOWER(CONCAT('%', :talle, '%'))) AND "
    + "(:color IS NULL OR LOWER(p.color) LIKE LOWER(CONCAT('%', :color, '%')))", nativeQuery = true)
    public Page<Producto> findAll(@Param("nombre") String nombre, @Param("codigo") String codigo, @Param("talle") String talle, @Param("color") String color, Pageable pageable);
    
}
