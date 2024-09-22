package com.example.demo.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.TrnHeader;

public interface TrnHeaderRepository extends JpaRepository<TrnHeader, Integer> {
}
