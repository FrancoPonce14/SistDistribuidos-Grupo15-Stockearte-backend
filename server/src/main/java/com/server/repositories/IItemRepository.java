package com.server.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.Item;

public interface IItemRepository extends JpaRepository<Item, Long>{
    public List<Item> findByOrdenCompraId(Long idOrdenCompra);
}
