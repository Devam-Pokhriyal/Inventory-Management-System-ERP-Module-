package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.VendorMaster;
import com.example.demo.Model.VendorMasterRepository;
@RestController
@RequestMapping("/api/vendor-master")
public class VendorMasterController {
    @Autowired
    private VendorMasterRepository vendorMasterRepository;

    @GetMapping
    public List<VendorMaster> getAllVendorMasters() {
        return vendorMasterRepository.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<VendorMaster> getVendorMasterByCode(@PathVariable String code) {
        return vendorMasterRepository.findById(code)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VendorMaster> createVendorMaster(@RequestBody VendorMaster vendorMaster) {
        if (vendorMaster.getCode() == null || vendorMaster.getCode().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        VendorMaster savedVendor = vendorMasterRepository.save(vendorMaster);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVendor);
    }

    @PutMapping("/{code}")
    public ResponseEntity<VendorMaster> updateVendorMaster(@PathVariable String code, @RequestBody VendorMaster vendorMasterDetails) {
        System.out.println("Received PUT request with code: " + code);
        System.out.println("Request body: " + vendorMasterDetails);
        
        return vendorMasterRepository.findById(code)
                .map(vendorMaster -> {
                    vendorMaster.setName(vendorMasterDetails.getName());
                    vendorMaster.setDescription(vendorMasterDetails.getDescription());
                    vendorMasterRepository.save(vendorMaster);
                    return ResponseEntity.ok(vendorMaster);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteVendorMaster(@PathVariable String code) {
        if (vendorMasterRepository.existsById(code)) {
            vendorMasterRepository.deleteById(code);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
