package com.example.demo.Model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.TrnDetails;
import com.example.demo.Entity.TrnDetailsId;

public interface TrnDetailsRepository extends JpaRepository<TrnDetails, TrnDetailsId> {

    static List<TrnDetails> findAllById(List<Long> transactionIds) {
        return null;
    }
}
