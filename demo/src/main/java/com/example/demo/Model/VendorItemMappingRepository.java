package com.example.demo.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.VendorItemMapping;
import com.example.demo.Entity.VendorItemMappingId;

import java.util.List;

@Repository
public interface VendorItemMappingRepository extends JpaRepository<VendorItemMapping, VendorItemMappingId> {

    @Query("SELECT v.id.itemCode FROM VendorItemMapping v WHERE v.id.code = :code")
    List<String> findItemCodesByVendorCode(@Param("code") String code);
}
