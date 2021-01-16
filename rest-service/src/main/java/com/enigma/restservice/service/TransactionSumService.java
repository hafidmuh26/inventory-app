package com.enigma.restservice.service;

import com.enigma.restservice.model.classmodel.TransactionSummary;

import java.time.Month;
import java.time.Year;
import java.util.List;

public interface TransactionSumService {

    List<TransactionSummary> summary(Year year, Month month, Integer date);
}
