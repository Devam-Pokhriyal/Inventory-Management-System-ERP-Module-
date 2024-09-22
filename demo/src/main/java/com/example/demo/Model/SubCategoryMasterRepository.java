package com.example.demo.Model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.SubCategoryMaster;
import com.example.demo.Entity.SubCategoryMasterId;

public interface SubCategoryMasterRepository extends JpaRepository<SubCategoryMaster, SubCategoryMasterId> {

    @Query("SELECT s.id.name FROM SubCategoryMaster s WHERE s.id.categoryName = :categoryName")
    List<String> findNamesByCategoryName(@Param("categoryName") String categoryName);
}    
