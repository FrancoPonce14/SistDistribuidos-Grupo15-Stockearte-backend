package com.server.soap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.server.entities.Filtro;
import com.server.entities.Usuario;
import com.server.exceptions.ServerException;
import com.server.filtro.CrearFiltroRequest;
import com.server.filtro.CrearFiltroResponse;
import com.server.filtro.EditarFiltroRequest;
import com.server.filtro.EditarFiltroResponse;
import com.server.filtro.TraerFiltrosRequest;
import com.server.filtro.TraerFiltrosResponse;
import com.server.repositories.IFiltroRepository;
import com.server.repositories.IUsuarioRepository;

@Service
public class SPfiltroService {

    @Autowired
    private IFiltroRepository filtroRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public CrearFiltroResponse crearFiltro(CrearFiltroRequest request) {
        Filtro filtro = new Filtro();
        filtro.setNombre(request.getNombreFiltro());
        filtro.setIdProducto(request.getIdProducto());
        filtro.setFechaDesde(request.getFechaDesde());
        filtro.setFechaHasta(request.getFechaHasta());
        filtro.setEstadoOrdenCompra(request.getEstado());
        filtro.setCodigoTienda(request.getCodigoTienda());
        Usuario usuario = usuarioRepository.findById(request.getIdUsuario()).orElseThrow(
                () -> new ServerException("Usuario no encontrado", HttpStatus.BAD_REQUEST));
        filtro.setUsuario(usuario);

        filtroRepository.save(filtro);

        CrearFiltroResponse response = new CrearFiltroResponse();
        response.setMensaje("Filtro creado!");
        return response;
    }

    public EditarFiltroResponse editarFiltro(EditarFiltroRequest request) {
        Filtro filtro = filtroRepository.findById(request.getIdFiltro())
        .orElseThrow(() -> new ServerException("Filtro no encontrado", HttpStatus.BAD_REQUEST));
        filtro.setNombre(request.getNombreFiltro());
        filtro.setIdProducto(request.getIdProducto());
        filtro.setFechaDesde(request.getFechaDesde());
        filtro.setFechaHasta(request.getFechaHasta());
        filtro.setEstadoOrdenCompra(request.getEstado());
        filtro.setCodigoTienda(request.getCodigoTienda());
        
        filtroRepository.save(filtro);

        EditarFiltroResponse response = new EditarFiltroResponse();
        response.setMensaje("Filtro editado!");
        return response;
    }

    public TraerFiltrosResponse traerFiltros(TraerFiltrosRequest request) {
        Usuario usuario = usuarioRepository.findById(request.getIdUsuario())
                .orElseThrow(() -> new ServerException("Usuario no encontrado", HttpStatus.BAD_REQUEST));

        List<Filtro> filtros = filtroRepository.findByUsuarioId(usuario.getId());

        TraerFiltrosResponse response = new TraerFiltrosResponse();      
        for (Filtro filtro : filtros) {
            TraerFiltrosResponse.Filtro fResponse = new TraerFiltrosResponse.Filtro();
            fResponse.setIdFiltro(filtro.getId());
            fResponse.setNombreFiltro(filtro.getNombre());
            fResponse.setIdProducto(filtro.getIdProducto());
            fResponse.setFechaDesde(filtro.getFechaDesde());
            fResponse.setFechaHasta(filtro.getFechaHasta());
            fResponse.setEstado(filtro.getEstadoOrdenCompra());
            fResponse.setCodigoTienda(filtro.getCodigoTienda());
            response.getFiltro().add(fResponse);
        }
        return response;
    }
    
}
