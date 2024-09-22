package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.TrnDetails;
import com.example.demo.Entity.TrnDetailsId;
import com.example.demo.Model.TrnDetailsRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trn-details")
public class TrnDetailsController {
    @Autowired
    private TrnDetailsRepository trnDetailsRepository;

    @GetMapping
    public List<TrnDetails> getAllTrnDetails() {
        return trnDetailsRepository.findAll();
    }

    @GetMapping("/{trnRefNo}/{lineNumber}")
    public Optional<TrnDetails> getTrnDetailsById(@PathVariable String trnRefNo, @PathVariable Integer lineNumber) {
        TrnDetailsId id = new TrnDetailsId();
        id.setTrnRefNo(trnRefNo);
        id.setLineNumber(lineNumber);
        return trnDetailsRepository.findById(id);
    }

    @PostMapping
    public TrnDetails createTrnDetails(@RequestBody TrnDetails trnDetails) {
        return trnDetailsRepository.save(trnDetails);
    }

    @PutMapping("/{trnRefNo}/{lineNumber}")
    public Optional<TrnDetails> updateTrnDetails(@PathVariable String trnRefNo, @PathVariable Integer lineNumber, @RequestBody TrnDetails trnDetailsDetails) {
        TrnDetailsId id = new TrnDetailsId();
        id.setTrnRefNo(trnRefNo);
        id.setLineNumber(lineNumber);
        return trnDetailsRepository.findById(id).map(trnDetails -> {
            trnDetails.setItemCode(trnDetailsDetails.getItemCode());
            trnDetails.setItemDesc(trnDetailsDetails.getItemDesc());
            trnDetails.setFromUom(trnDetailsDetails.getFromUom());
            trnDetails.setToUom(trnDetailsDetails.getToUom());
            trnDetails.setItemQty(trnDetailsDetails.getItemQty());
            trnDetails.setItemRate(trnDetailsDetails.getItemRate());
            return trnDetailsRepository.save(trnDetails);
        });
    }

    @DeleteMapping("/{trnRefNo}/{lineNumber}")
    public void deleteTrnDetails(@PathVariable String trnRefNo, @PathVariable Integer lineNumber) {
        TrnDetailsId id = new TrnDetailsId();
        id.setTrnRefNo(trnRefNo);
        id.setLineNumber(lineNumber);
        trnDetailsRepository.deleteById(id);
    }
}
