package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.TrnDef;
import com.example.demo.Entity.TrnDef.TrnDefId;
import com.example.demo.Model.TrnDefRepository;

@RestController
@RequestMapping("/api/trn-def")
public class TrnDefController {

    @Autowired
    private TrnDefRepository trnDefRepository;

    @GetMapping("/types")
public List<TrnDef> gettypeTrnDefs() {
    return trnDefRepository.findAll();
}


    @GetMapping
    public List<TrnDef> getAllTrnDefs() {
        return trnDefRepository.findAll();
    }

    @GetMapping("/{trnType}/{trnCode}")
    public ResponseEntity<TrnDef> getTrnDefById(@PathVariable String trnType, @PathVariable String trnCode) {
        TrnDefId id = new TrnDefId(trnType, trnCode);
        Optional<TrnDef> trnDef = trnDefRepository.findById(id);
        return trnDef.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
 




    @PatchMapping("/{trnType}/{trnCode}")
    public ResponseEntity<TrnDef> updateNextNo(@PathVariable String trnType, @PathVariable String trnCode, @RequestBody Map<String, Object> updates) {
        TrnDefId id = new TrnDefId(trnType, trnCode);
        Optional<TrnDef> trnDefOptional = trnDefRepository.findById(id);

        if (trnDefOptional.isPresent()) {
            TrnDef trnDef = trnDefOptional.get();
            // Update nextno if provided in the request body
            if (updates.containsKey("nextno")) {
                trnDef.setNextno(((Number) updates.get("nextno")).longValue());
            }
            return ResponseEntity.ok(trnDefRepository.save(trnDef));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   
    

    @PostMapping
    public TrnDef createTrnDef(@RequestBody TrnDef trnDef) {
        return trnDefRepository.save(trnDef);
    }

    @PutMapping("/{trnType}/{trnCode}")
    public ResponseEntity<TrnDef> updateTrnDef(@PathVariable String trnType, @PathVariable String trnCode, @RequestBody TrnDef trnDefDetails) {
        TrnDefId id = new TrnDefId(trnType, trnCode);
        Optional<TrnDef> trnDefOptional = trnDefRepository.findById(id);

        if (trnDefOptional.isPresent()) {
            TrnDef trnDef = trnDefOptional.get();
            trnDef.setTrnDescription(trnDefDetails.getTrnDescription());
            trnDef.setSeries(trnDefDetails.getSeries());
            trnDef.setNextno(trnDefDetails.getNextno());
            trnDef.setSerial(trnDefDetails.getSerial());

            return ResponseEntity.ok(trnDefRepository.save(trnDef));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{trnType}/{trnCode}")
    public ResponseEntity<Void> deleteTrnDef(@PathVariable String trnType, @PathVariable String trnCode) {
        TrnDefId id = new TrnDefId(trnType, trnCode);
        if (trnDefRepository.existsById(id)) {
            trnDefRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
