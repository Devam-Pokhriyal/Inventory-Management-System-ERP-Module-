package com.example.demo.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.CategoryMaster;

public interface CategoryMasterRepository extends JpaRepository<CategoryMaster, String> {
}
