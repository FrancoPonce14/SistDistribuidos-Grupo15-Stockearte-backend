package com.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
