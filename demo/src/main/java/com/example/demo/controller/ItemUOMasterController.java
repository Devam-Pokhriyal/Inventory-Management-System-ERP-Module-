package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.ItemUOMaster;
import com.example.demo.Entity.ItemUOMasterId;
import com.example.demo.Model.ItemUOMasterRepository;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/item-uom-master")
public class ItemUOMasterController {
    @Autowired
    private ItemUOMasterRepository itemUOMasterRepository;

    @GetMapping
    public List<ItemUOMaster> getAllItemUOMasters() {
        return itemUOMasterRepository.findAll();
    }
    
    @GetMapping("/{fromUom}/{itemCode}/{toUom}")
    public Optional<ItemUOMaster> getItemUOMasterById(@PathVariable String fromUom, @PathVariable String itemCode, @PathVariable String toUom) {
        ItemUOMasterId id = new ItemUOMasterId();
        id.setFromUom(fromUom);
        id.setItemCode(itemCode);
        id.setToUom(toUom);
        return itemUOMasterRepository.findById(id);
    }

    @PostMapping
    public ItemUOMaster createItemUOMaster(@RequestBody ItemUOMaster itemUOMaster) {
        return itemUOMasterRepository.save(itemUOMaster);
    }

    @PutMapping("/{fromUom}/{itemCode}/{toUom}")
    public Optional<ItemUOMaster> updateItemUOMaster(@PathVariable String fromUom, @PathVariable String itemCode, @PathVariable String toUom, @RequestBody ItemUOMaster itemUOMasterDetails) {
        ItemUOMasterId id = new ItemUOMasterId();
        id.setFromUom(fromUom);
        id.setItemCode(itemCode);
        id.setToUom(toUom);
        return itemUOMasterRepository.findById(id).map(itemUOMaster -> {
            itemUOMaster.setCf(itemUOMasterDetails.getCf());
            itemUOMaster.setRcf(itemUOMasterDetails.getRcf());
            itemUOMaster.setUomValue(itemUOMaster.getUomValue());
          
            return itemUOMasterRepository.save(itemUOMaster);
        });
    }

    @DeleteMapping("/{fromUom}/{itemCode}/{toUom}")
    public void deleteItemUOMaster(@PathVariable String fromUom, @PathVariable String itemCode, @PathVariable String toUom) {
        ItemUOMasterId id = new ItemUOMasterId();
        id.setFromUom(fromUom);
        id.setItemCode(itemCode);
        id.setToUom(toUom);
        itemUOMasterRepository.deleteById(id);
    }
}
