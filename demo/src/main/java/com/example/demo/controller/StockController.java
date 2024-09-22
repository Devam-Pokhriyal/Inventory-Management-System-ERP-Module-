package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Stock;
import com.example.demo.Entity.StockId;
import com.example.demo.Model.StockRepository;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    // Get all stock records
    @GetMapping
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
   


    // Create a new stock record
    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        return stockRepository.save(stock);
    }

    // Update a stock record
    @PutMapping
    public Stock updateStock(@RequestBody Stock stock) {
        return stockRepository.save(stock);
    }

    // Delete a stock record
    @DeleteMapping("/{financialYear}/{location}/{itemCode}")
    public void deleteStock(
        @PathVariable("financialYear") Date financialYear,
        @PathVariable("location") String location,
        @PathVariable("itemCode") String itemCode) {
        
        StockId stockId = new StockId();
        stockId.setFinancialYear(financialYear);
        stockId.setLocation(location);
        stockId.setItemCode(itemCode);
        stockRepository.deleteById(stockId);
    }
}
