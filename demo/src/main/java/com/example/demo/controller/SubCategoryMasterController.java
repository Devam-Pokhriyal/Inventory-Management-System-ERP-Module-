package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.SubCategoryMaster;
import com.example.demo.Entity.SubCategoryMasterId;
import com.example.demo.Model.SubCategoryMasterRepository;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/sub-category-master")
public class SubCategoryMasterController {
    @Autowired
    private SubCategoryMasterRepository subCategoryMasterRepository;

    @GetMapping
    public List<SubCategoryMaster> getAllSubCategoryMasters() {
        return subCategoryMasterRepository.findAll();
    }

    @GetMapping("/category/{categoryName}")
    public List<String> getSubCategoryNamesByCategoryName(@PathVariable String categoryName) {
        return subCategoryMasterRepository.findNamesByCategoryName(categoryName);
    }

    @GetMapping("/{categoryName}/{name}")
    public Optional<SubCategoryMaster> getSubCategoryMasterById(
            @PathVariable String categoryName,
            @PathVariable String name) {
        SubCategoryMasterId id = new SubCategoryMasterId();
        id.setCategoryName(categoryName);
        id.setName(name);
        return subCategoryMasterRepository.findById(id);
    }

    @PostMapping
    public SubCategoryMaster createSubCategoryMaster(@RequestBody SubCategoryMaster subCategoryMaster) {
        return subCategoryMasterRepository.save(subCategoryMaster);
    }

    @PutMapping("/{categoryName}/{name}")
    public Optional<SubCategoryMaster> updateSubCategoryMaster(
            @PathVariable String categoryName,
            @PathVariable String name,
            @RequestBody SubCategoryMaster subCategoryMasterDetails) {
        SubCategoryMasterId id = new SubCategoryMasterId();
        id.setCategoryName(categoryName);
        id.setName(name);
        return subCategoryMasterRepository.findById(id).map(subCategoryMaster -> {
            subCategoryMaster.setDescription(subCategoryMasterDetails.getDescription());
            return subCategoryMasterRepository.save(subCategoryMaster);
        });
    }

    @DeleteMapping("/{categoryName}/{name}")
    public void deleteSubCategoryMaster(@PathVariable String categoryName, @PathVariable String name) {
        SubCategoryMasterId id = new SubCategoryMasterId();
        id.setCategoryName(categoryName);
        id.setName(name);
        subCategoryMasterRepository.deleteById(id);
    }
}
