package com.example.demo.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.TrnDef;
import com.example.demo.Entity.TrnDef.TrnDefId;

@Repository
public interface TrnDefRepository extends JpaRepository<TrnDef, TrnDefId> {
    
}
