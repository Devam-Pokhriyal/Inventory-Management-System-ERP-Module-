package com.example.demo.Model;

import com.example.demo.Entity.ItemMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMasterRepository extends JpaRepository<ItemMaster, String> {
     
    @Query("SELECT i.unitOfMeasure FROM ItemMaster i WHERE i.itemCode = :itemCode")

    String findUnitOfMeasureByItemCode(@Param("itemCode") String itemCode);


}


