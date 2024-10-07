package com.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.OrdenDespacho;

public interface IOrdenDespachoRepository extends JpaRepository<OrdenDespacho, Long>{
    
}
