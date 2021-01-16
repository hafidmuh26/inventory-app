package com.enigma.restservice.repositories;


import com.enigma.restservice.model.classmodel.StockSummary;

import java.sql.SQLException;
import java.util.List;


public interface StockRepositoryCustom {
    List<StockSummary> summary() throws SQLException;
}
