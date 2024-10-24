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
    @Query(value = "SELECT p.* FROM tienda t INNER JOIN stock s ON t.id = s.tienda_id INNER JOIN producto p ON s.producto_id = p.id WHERE t.codigo = :codigoTienda AND p.id = :idProducto", nativeQuery = true)
    public Optional<Producto> findByCodigos(@Param("codigoTienda") String codigoTienda, @Param("idProducto") Long idProducto);  
    @Query(value = "SELECT p.* FROM Producto p WHERE p.id NOT IN (SELECT s.producto_id FROM Stock s WHERE s.tienda_id = :tiendaId)", nativeQuery = true)
    public List<Producto> findProductosNoAsociados(@Param("tiendaId") Long tiendaId);
    @Query(value = "SELECT p.* FROM Producto p JOIN Stock s ON p.id = s.producto_id WHERE s.tienda_id = :tiendaId", nativeQuery = true)
    public List<Producto> findProductosAsociados(@Param("tiendaId") Long tiendaId);
    @Query(value = "SELECT p.* FROM producto p JOIN stock s ON p.id = s.producto_id WHERE s.tienda_id = :tiendaId AND (:nombre IS NULL OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND (:codigo IS NULL OR LOWER(p.codigo) LIKE LOWER(CONCAT('%', :codigo, '%'))) AND (:talle IS NULL OR LOWER(p.talle) LIKE LOWER(CONCAT('%', :talle, '%'))) AND (:color IS NULL OR LOWER(p.color) LIKE LOWER(CONCAT('%', :color, '%')))", nativeQuery = true)
    public Page<Producto> findByTienda(@Param("tiendaId") Long tiendaId, @Param("nombre") String nombre, @Param("codigo") String codigo, @Param("talle") String talle, @Param("color") String color, Pageable pageable);
    @Query(value = "SELECT p.* FROM producto p WHERE (p.nombre IS NULL OR p.nombre LIKE CONCAT(:nombre, '%')) AND (:codigo IS NULL OR p.codigo LIKE CONCAT('%', :codigo, '%')) AND (:talle IS NULL OR p.talle LIKE CONCAT('%', :talle, '%')) AND (:color IS NULL OR p.color LIKE CONCAT('%', :color, '%'))", nativeQuery = true)
    public Page<Producto> findAll(@Param("nombre") String nombre, @Param("codigo") String codigo, @Param("talle") String talle, @Param("color") String color, Pageable pageable);
    @Query(value = "SELECT p.* FROM producto p WHERE p.id NOT IN (SELECT cp.producto_id FROM catalogo_producto cp WHERE cp.catalogo_id = :idCatalogo)", nativeQuery = true)
    public List<Producto> findProductosNoAsignadosACatalogo(@Param("idCatalogo") Long idCatalogo);
    
}
