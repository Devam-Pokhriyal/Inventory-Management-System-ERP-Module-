package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.VendorItemMapping;
import com.example.demo.Entity.VendorItemMappingId;
import com.example.demo.Model.VendorItemMappingRepository;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/vendor-item-mapping")
public class VendorItemMappingController {

    @Autowired
    private VendorItemMappingRepository vendorItemMappingRepository;

    @GetMapping
    public List<VendorItemMapping> getAllVendorItemMappings() {
        return vendorItemMappingRepository.findAll();
    }

    @GetMapping("/{code}/{itemCode}")
    public Optional<VendorItemMapping> getVendorItemMappingById(@PathVariable String code, @PathVariable String itemCode) {
        VendorItemMappingId id = new VendorItemMappingId(code, itemCode);
        return vendorItemMappingRepository.findById(id);
    }
    @GetMapping("/item-codes/{code}")
    public List<String> getItemCodesByVendorCode(@PathVariable String code) {
        return vendorItemMappingRepository.findItemCodesByVendorCode(code);
    }
    @PostMapping
    public VendorItemMapping createVendorItemMapping(@RequestBody VendorItemMapping vendorItemMapping) {
        return vendorItemMappingRepository.save(vendorItemMapping);
    }

    @PutMapping("/{code}/{itemCode}")
    public ResponseEntity<VendorItemMapping> updateVendorItemMapping(@PathVariable String code, 
                                                                     @PathVariable String itemCode, 
                                                                     @RequestBody VendorItemMapping vendorItemMappingDetails) {
        VendorItemMappingId id = new VendorItemMappingId(code, itemCode);
        Optional<VendorItemMapping> vendorItemMappingOptional = vendorItemMappingRepository.findById(id);

        if (vendorItemMappingOptional.isPresent()) {
            VendorItemMapping vendorItemMapping = vendorItemMappingOptional.get();
            vendorItemMapping.setId(vendorItemMappingDetails.getId());
            VendorItemMapping updatedVendorItemMapping = vendorItemMappingRepository.save(vendorItemMapping);
            return ResponseEntity.ok(updatedVendorItemMapping);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{code}/{itemCode}")
    public ResponseEntity<Void> deleteVendorItemMapping(@PathVariable String code, @PathVariable String itemCode) {
        VendorItemMappingId id = new VendorItemMappingId(code, itemCode);
        if (vendorItemMappingRepository.existsById(id)) {
            vendorItemMappingRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
