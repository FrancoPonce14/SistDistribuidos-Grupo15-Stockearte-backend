package com.server.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.server.entities.OrdenCompra;

public interface IOrdenCompraRepository extends JpaRepository<OrdenCompra, Long>{
    public List<OrdenCompra> findByTiendaId(Long idTienda);

    @Query(value = "SELECT * FROM orden_compra oc JOIN item i ON oc.id = i.orden_compra_id JOIN producto p ON i.producto_id = p.id JOIN tienda t ON oc.tienda_id = t.id WHERE (:idProducto IS NULL OR p.id = :idProducto) AND (:fechaDesde IS NULL OR :fechaHasta IS NULL OR oc.fecha_solicitud BETWEEN :fechaDesde AND :fechaHasta) AND (:estado IS NULL OR oc.estado = :estado) AND (:codigoTienda IS NULL OR t.codigo = :codigoTienda)", nativeQuery = true)
    public Page<OrdenCompra> findAll(@Param("idProducto") Long idProducto, @Param("fechaDesde") Date fechaDesde, @Param("fechaHasta") Date fechaHasta, @Param("estado") String estado, @Param("codigoTienda") String codigoTienda, Pageable pageable);

}
