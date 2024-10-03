package com.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entities.Item;

public interface IItemRepository extends JpaRepository<Item, Long>{
    
}
