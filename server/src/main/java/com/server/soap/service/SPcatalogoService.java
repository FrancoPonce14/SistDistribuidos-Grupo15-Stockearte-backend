package com.server.soap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.catalogo.CrearCatalogoRequest;
import com.server.catalogo.CrearCatalogoResponse;
import com.server.repositories.ICatalogoRepository;

@Service
public class SPcatalogoService {

    @Autowired
    private ICatalogoRepository catalogoRepository;

    public CrearCatalogoResponse crearCatalogo(CrearCatalogoRequest request){
        return null;
    }
    
}
