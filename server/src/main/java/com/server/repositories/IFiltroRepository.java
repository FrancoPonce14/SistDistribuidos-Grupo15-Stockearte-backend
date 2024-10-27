package com.server.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.Filtro;

public interface IFiltroRepository extends JpaRepository<Filtro, Long>{
    public List<Filtro> findByUsuarioId(Long idUsuario);
}
