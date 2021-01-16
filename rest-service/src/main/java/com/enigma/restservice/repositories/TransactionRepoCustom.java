package com.enigma.restservice.repositories;

import com.enigma.restservice.model.classmodel.TransactionSummary;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepoCustom {
    List<TransactionSummary> summary(LocalDate from, LocalDate to);
}
