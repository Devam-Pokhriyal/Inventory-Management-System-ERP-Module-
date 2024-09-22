package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.UomMaster;
import com.example.demo.Model.UomMasterRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/uom-master")
public class UomMasterController {
    @Autowired
    private UomMasterRepository uomMasterRepository;

    @GetMapping
    public List<UomMaster> getAllUomMasters() {
        return uomMasterRepository.findAll();
    }

    @GetMapping("/{name}")
    public Optional<UomMaster> getUomMasterByName(@PathVariable String name) {
        return uomMasterRepository.findById(name);
    }

    @PostMapping
    public UomMaster createUomMaster(@RequestBody UomMaster uomMaster) {
        return uomMasterRepository.save(uomMaster);
    }

    @PutMapping("/{name}")
    public Optional<UomMaster> updateUomMaster(@PathVariable String name, @RequestBody UomMaster uomMasterDetails) {
        return uomMasterRepository.findById(name).map(uomMaster -> {
            uomMaster.setDescription(uomMasterDetails.getDescription());
            uomMaster.setUomCode(uomMasterDetails.getUomCode());
            uomMaster.setUomDesc(uomMasterDetails.getUomDesc());
            return uomMasterRepository.save(uomMaster);
        });
    }

    @DeleteMapping("/{name}")
    public void deleteUomMaster(@PathVariable String name) {
        uomMasterRepository.deleteById(name);
    }
}
