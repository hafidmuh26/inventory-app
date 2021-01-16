package com.enigma.restservice.service.Impl;

import com.enigma.restservice.model.classmodel.StockSummary;
import com.enigma.restservice.repositories.StockRepository;
import com.enigma.restservice.service.StockSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StockSummaryImpl implements StockSummaryService {

    @Autowired
    private StockRepository repository;

    @Override
    public List<StockSummary> stockSummary() throws SQLException {
        return repository.summary();
    }
}
