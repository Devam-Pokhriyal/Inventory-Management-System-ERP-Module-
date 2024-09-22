package com.example.demo.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Stock;
import com.example.demo.Entity.StockId;

@Repository
public interface StockRepository extends JpaRepository<Stock, StockId> {
    // Custom queries can be added here if needed
}
