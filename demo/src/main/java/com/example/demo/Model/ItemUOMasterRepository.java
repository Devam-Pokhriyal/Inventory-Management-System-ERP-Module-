package com.example.demo.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.ItemUOMaster;
import com.example.demo.Entity.ItemUOMasterId;

public interface ItemUOMasterRepository extends JpaRepository<ItemUOMaster, ItemUOMasterId> {
    
}
