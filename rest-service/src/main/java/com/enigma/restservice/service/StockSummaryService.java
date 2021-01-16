package com.enigma.restservice.service;

import com.enigma.restservice.model.classmodel.StockSummary;

import java.sql.SQLException;
import java.util.List;

public interface StockSummaryService {

    List<StockSummary> stockSummary() throws SQLException;
}
