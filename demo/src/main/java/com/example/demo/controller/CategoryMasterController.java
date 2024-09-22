package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.CategoryMaster;
import com.example.demo.Model.CategoryMasterRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category-master")
public class CategoryMasterController {

    @Autowired
    private CategoryMasterRepository categoryMasterRepository;

    @GetMapping
    public List<CategoryMaster> getAllCategoryMasters() {
        return categoryMasterRepository.findAll();
    }

    @GetMapping("/{name}")
    public Optional<CategoryMaster> getCategoryMasterByName(@PathVariable String name) {
        return categoryMasterRepository.findById(name);
    }

   @PostMapping
    public CategoryMaster createCategoryMaster(@RequestBody CategoryMaster categoryMaster) {
        return categoryMasterRepository.save(categoryMaster);
    }

    @PutMapping("/{name}")
    public Optional<CategoryMaster> updateCategoryMaster(@PathVariable String name, @RequestBody CategoryMaster categoryMasterDetails) {
        return categoryMasterRepository.findById(name).map(categoryMaster -> {
            categoryMaster.setDescription(categoryMasterDetails.getDescription());
            return categoryMasterRepository.save(categoryMaster);
        });
    }

    @DeleteMapping("/{name}")
    public void deleteCategoryMaster(@PathVariable String name) {
        categoryMasterRepository.deleteById(name);
    }
}
