package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.TrnHeader;
import com.example.demo.Model.TrnHeaderRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trn-header")
public class TrnHeaderController {
    @Autowired
    private TrnHeaderRepository trnHeaderRepository;
    
    @GetMapping
    public List<TrnHeader> getAllTrnHeaders() {
        return trnHeaderRepository.findAll();
    }

    @GetMapping("/{trnRefNo}")
    public Optional<TrnHeader> getTrnHeaderByTrnRefNo(@PathVariable Integer trnRefNo) {
        return trnHeaderRepository.findById(trnRefNo);
    }

    @PostMapping
    public TrnHeader createTrnHeader(@RequestBody TrnHeader trnHeader) {
        return trnHeaderRepository.save(trnHeader);
    }

    @PutMapping("/{trnRefNo}")
    public Optional<TrnHeader> updateTrnHeader(@PathVariable Integer trnRefNo, @RequestBody TrnHeader trnHeaderDetails) {
        return trnHeaderRepository.findById(trnRefNo).map(trnHeader -> {
            trnHeader.setTrnDate(trnHeaderDetails.getTrnDate());
            trnHeader.setVendorCode(trnHeaderDetails.getVendorCode());
            trnHeader.setRefNo(trnHeaderDetails.getRefNo());
            trnHeader.setTrnType(trnHeaderDetails.getTrnType());
            trnHeader.setTrnCode(trnHeaderDetails.getTrnCode());
            trnHeader.setCreatedBy(trnHeaderDetails.getCreatedBy());
            trnHeader.setCreatedFor(trnHeaderDetails.getCreatedFor());
            trnHeader.setStatus(trnHeaderDetails.getStatus());
            return trnHeaderRepository.save(trnHeader);
        });
    }

    @DeleteMapping("/{trnRefNo}")
    public void deleteTrnHeader(@PathVariable Integer trnRefNo) {
        trnHeaderRepository.deleteById(trnRefNo);
    }
}
