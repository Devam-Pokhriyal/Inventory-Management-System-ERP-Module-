// package com.example.demo.Service;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.Entity.Item;
// import com.example.demo.Model.ItemRepository;

// @Service
// public class ItemService {

//     @Autowired
//     private ItemRepository itemRepository;

//     public Item save(Item item) {
//         return itemRepository.save(item);
//     }

//     public Item update(Item item) {
//         Optional<Item> optionalItem = itemRepository.findById(item.getId());
//         if (optionalItem.isPresent()) {
//             Item existingItem = optionalItem.get();
//             existingItem.setItemCode(item.getItemCode());
//             existingItem.setItemName(item.getItemName());
//             existingItem.setDescription(item.getDescription());
//             existingItem.setCategory(item.getCategory());
//             existingItem.setUnitPrice(item.getUnitPrice());
//             existingItem.setSupplierName(item.getSupplierName());
//             existingItem.setBarcode(item.getBarcode());
//             existingItem.setQuantity(item.getQuantity());
//             return itemRepository.save(existingItem);
//         } else {
//             return null;
//         }
//     }

//     public void delete(Long id) {
//         itemRepository.deleteById(id);
//     }

// }