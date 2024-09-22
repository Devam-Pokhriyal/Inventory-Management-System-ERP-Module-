package com.example.demo.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.VendorMaster;

public interface VendorMasterRepository extends JpaRepository<VendorMaster, String> {
}