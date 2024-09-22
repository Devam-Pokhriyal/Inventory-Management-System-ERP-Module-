package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.LocationMaster;
import com.example.demo.Model.LocationMasterRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/location-master")
public class LocationMasterController {
    @Autowired
    private LocationMasterRepository locationMasterRepository;

    @GetMapping
    public List<LocationMaster> getAllLocationMasters() {
        return locationMasterRepository.findAll();
    }

    @GetMapping("/{name}")
    public Optional<LocationMaster> getLocationMasterByName(@PathVariable String name) {
        return locationMasterRepository.findById(name);
    }

    @PostMapping
    public LocationMaster createLocationMaster(@RequestBody LocationMaster locationMaster) {
        return locationMasterRepository.save(locationMaster);
    }

    @PutMapping("/{name}")
    public Optional<LocationMaster> updateLocationMaster(@PathVariable String name, @RequestBody LocationMaster locationMasterDetails) {
        return locationMasterRepository.findById(name).map(locationMaster -> {
            locationMaster.setDescription(locationMasterDetails.getDescription());
            return locationMasterRepository.save(locationMaster);
        });
    }

    @DeleteMapping("/{name}")
    public void deleteLocationMaster(@PathVariable String name) {
        locationMasterRepository.deleteById(name);
    }
}
