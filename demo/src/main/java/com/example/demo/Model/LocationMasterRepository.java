package com.example.demo.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.LocationMaster;

public interface LocationMasterRepository extends JpaRepository<LocationMaster, String> {
}
