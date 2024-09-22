// package com.example.demo.Service;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.Entity.ItemMaster;
// import com.example.demo.Model.ItemMasterRepository;

// @Service
// public class ItemMasterService {

//     @Autowired
//     private ItemMasterRepository itemMasterRepository;

//     // Save a new item
//     public ItemMaster save(ItemMaster itemMaster) {
//         return itemMasterRepository.save(itemMaster);
//     }

//     // Update an existing item
//     public ItemMaster update(ItemMaster itemMaster) {
//         Optional<ItemMaster> optionalItemMaster = itemMasterRepository.findById(itemMaster.getId());
//         if (optionalItemMaster.isPresent()) {
//             ItemMaster existingItemMaster = optionalItemMaster.get();
//             existingItemMaster.setCode(itemMaster.getCode()); // Ensure field names match
//             existingItemMaster.setName(itemMaster.getName());
           
//             existingItemMaster.setCategory(itemMaster.getCategory());
//             existingItemMaster.setSubcategory(itemMaster.getSubcategory()); // Ensure this field exists in the entity
//             existingItemMaster.setUnitOfMeasure(itemMaster.getUnitOfMeasure()); // Ensure this field exists in the entity
//             existingItemMaster.setUnitPrice(itemMaster.getUnitPrice());
//             existingItemMaster.setCostPrice(itemMaster.getCostPrice()); // Ensure this field exists in the entity
//             existingItemMaster.setQuantity(itemMaster.getQuantity());
//             return itemMasterRepository.save(existingItemMaster);
//         } else {
//             throw new RuntimeException("Item not found with id: " + itemMaster.getId()); // Or use a custom exception
//         }
//     }

//     public void delete(Long id) {
//         itemMasterRepository.deleteById(id);
//     }
// }
