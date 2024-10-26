package com.server.soap.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.server.entities.Item;
import com.server.entities.OrdenCompra;
import com.server.entities.Producto;
import com.server.informe.OrdenesCompraRequest;
import com.server.informe.OrdenesCompraResponse;
import com.server.repositories.IOrdenCompraRepository;

@Service
public class SPinformeService {

    @Autowired
    private IOrdenCompraRepository ordenCompraRepository;

    @Transactional
    public OrdenesCompraResponse informeOrdenesCompra(OrdenesCompraRequest request) {
        int page = 1;
        int size = 9999;
        PageRequest pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "id"));
        Long idProducto = request.getIdProducto();
        Date fechaDesde = (request.getFechaDesde() != null) ? request.getFechaDesde().toGregorianCalendar().getTime() : null;
        Date fechaHasta = (request.getFechaHasta() != null) ? request.getFechaHasta().toGregorianCalendar().getTime() : null;
        String estado = request.getEstado().isEmpty() ? null : request.getEstado();
        String codigoTienda = request.getCodigoTienda().isEmpty() ? null : request.getCodigoTienda();

        Page<OrdenCompra> ordenesCompra = ordenCompraRepository.findAll(idProducto, fechaDesde, fechaHasta, estado, codigoTienda, pageable);

        OrdenesCompraResponse response = new OrdenesCompraResponse();
        List<OrdenesCompraResponse.Orden> ordenList = response.getOrden();

        for (OrdenCompra oc : ordenesCompra) {
            for (Item item : oc.getItems()) {
                Producto producto = item.getProducto();

                OrdenesCompraResponse.Orden orden = new OrdenesCompraResponse.Orden();
                orden.setNombreProducto(producto.getNombre());
                orden.setColor(producto.getColor());
                orden.setTalle(producto.getTalle());
                orden.setCodigoTienda(oc.getTienda().getCodigo());
                orden.setEstado(oc.getEstado());
                orden.setCantidad(item.getCantidad());

                ordenList.add(orden);
            }
        }

        response.setResultado("bien");

        return response;
    }

}
