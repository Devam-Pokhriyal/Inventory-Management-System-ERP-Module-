package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.ItemMaster;
import com.example.demo.Model.ItemMasterRepository;

@RestController
@RequestMapping("/api/item-master")
public class ItemMasterController {

    @Autowired
    private ItemMasterRepository itemMasterRepository;

    // Create a new ItemMaster
    @PostMapping
    public ResponseEntity<ItemMaster> createItemMaster(@RequestBody ItemMaster itemMaster) {
        if (itemMaster.getItemCode() == null || itemMaster.getItemCode().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        System.out.println("Received item: " + itemMaster.getSubCategory());
        ItemMaster savedItem = itemMasterRepository.save(itemMaster);
        return ResponseEntity.ok(savedItem);
    }
   


    // Get all ItemMasters
    @GetMapping
    public ResponseEntity<List<ItemMaster>> getAllItemMasters() {
        List<ItemMaster> itemMasters = itemMasterRepository.findAll();
        return ResponseEntity.ok(itemMasters);
    }
    @GetMapping("/all")
    public ResponseEntity<List<ItemMaster>> getAllItems() {
        List<ItemMaster> items = itemMasterRepository.findAll();
        return ResponseEntity.ok(items);
    }

    // Get a single ItemMaster by itemCode
    @GetMapping("/{itemCode}")
    public ResponseEntity<ItemMaster> getItemMasterById(@PathVariable String itemCode) {
        Optional<ItemMaster> itemMaster = itemMasterRepository.findById(itemCode);
        return itemMaster.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing ItemMaster
    @PutMapping("/{itemCode}")
    public ResponseEntity<ItemMaster> updateItemMaster(
            @PathVariable String itemCode, 
            @RequestBody ItemMaster itemMasterDetails) {

        Optional<ItemMaster> itemMasterOptional = itemMasterRepository.findById(itemCode);
        if (itemMasterOptional.isPresent()) {
            ItemMaster itemMaster = itemMasterOptional.get();
            itemMaster.setCategoryName(itemMasterDetails.getCategoryName());
            itemMaster.setSubCategory(itemMasterDetails.getSubCategory()); // Ensure correct field name
           
            itemMaster.setUnitOfMeasure(itemMasterDetails.getUnitOfMeasure());
            itemMaster.setItemDescription(itemMasterDetails.getItemDescription());
            itemMaster.setNumberOfItems(itemMasterDetails.getNumberOfItems());
            itemMaster.setHsnCode(itemMasterDetails.getHsnCode());
            itemMaster.setUnitPrice(itemMasterDetails.getUnitPrice());
            itemMaster.setCostPrice(itemMasterDetails.getCostPrice());

            ItemMaster updatedItemMaster = itemMasterRepository.save(itemMaster);
            return ResponseEntity.ok(updatedItemMaster);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an ItemMaster by itemCode
    @DeleteMapping("/{itemCode}")
    public ResponseEntity<Void> deleteItemMaster(@PathVariable String itemCode) {
        Optional<ItemMaster> itemMasterOptional = itemMasterRepository.findById(itemCode);
        if (itemMasterOptional.isPresent()) {
            itemMasterRepository.delete(itemMasterOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
