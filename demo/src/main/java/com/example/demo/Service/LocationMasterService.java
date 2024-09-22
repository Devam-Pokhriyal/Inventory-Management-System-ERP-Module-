// package com.example.demo.Service;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.Entity.LocationMaster;
// import com.example.demo.Model.LocationMasterRepository;

// @Service
// public class LocationMasterService {

//     @Autowired
//     private LocationMasterRepository locationMasterRepository;

//     // Save a new location
//     public LocationMaster save(LocationMaster locationMaster) {
//         return locationMasterRepository.save(locationMaster);
//     }

//     // Update an existing location
//     public LocationMaster update(LocationMaster locationMaster) {
//         Optional<LocationMaster> optionalLocationMaster = locationMasterRepository.findById(locationMaster.getId());
//         if (optionalLocationMaster.isPresent()) {
//             LocationMaster existingLocationMaster = optionalLocationMaster.get();
//             existingLocationMaster.setItemId(locationMaster.getItemId());
//             existingLocationMaster.setLocationId(locationMaster.getLocationId());
//             existingLocationMaster.setQuantityOnHand(locationMaster.getQuantityOnHand());
//             existingLocationMaster.setQuantityReserved(locationMaster.getQuantityReserved());
//             existingLocationMaster.setQuantityAvailable(locationMaster.getQuantityAvailable());
//             existingLocationMaster.setLastReceiptDate(locationMaster.getLastReceiptDate());
//             existingLocationMaster.setLastIssueDate(locationMaster.getLastIssueDate());
//             existingLocationMaster.setLastCountDate(locationMaster.getLastCountDate());
//             existingLocationMaster.setStatus(locationMaster.getStatus());
//             existingLocationMaster.setLotNumber(locationMaster.getLotNumber());
//             existingLocationMaster.setSerialNumber(locationMaster.getSerialNumber());
//             existingLocationMaster.setExpirationDate(locationMaster.getExpirationDate());
//             return locationMasterRepository.save(existingLocationMaster);
//         } else {
//             throw new RuntimeException("Location not found with id: " + locationMaster.getId());
//         }
//     }

//     // Delete a location
//     public void delete(Long id) {
//         locationMasterRepository.deleteById(id);
//     }
// }
