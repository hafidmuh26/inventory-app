package com.enigma.restservice.service.Impl;

import com.enigma.restservice.entity.classentity.Transaction;
import com.enigma.restservice.exception.EntityNotFoundException;
import com.enigma.restservice.model.classmodel.TransactionSummary;
import com.enigma.restservice.repositories.TransactionRepository;
import com.enigma.restservice.service.IService;
import com.enigma.restservice.service.TransactionSumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;
import java.util.List;


@Service
public class TransactionServiceImpl implements IService<Transaction>, TransactionSumService {

    @Autowired
    private TransactionRepository repository;

    @Override
    public Transaction save(Transaction entity) {
        return repository.save(entity);
    }

    @Override
    public Transaction removeById(Integer id) {
        Transaction entity = findById(id);
        repository.delete(entity);

        return entity;
    }

    @Override
    public Transaction findById(Integer id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<Transaction> findAll(Transaction entity, int page, int size, Sort.Direction sort) {
        Sort s = Sort.Direction.DESC.equals(sort) ? Sort.by(sort, "id").descending() : Sort.by("id");

        ExampleMatcher matcher = ExampleMatcher.matchingAll().
                withIgnoreCase().
                withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        return repository.findAll(Example.of(entity, matcher), PageRequest.of(page, size, s));
    }

    @Override
    public List<TransactionSummary> summary(Year year, Month month, Integer date) {
        LocalDate from = LocalDate.of(year.getValue(), 1, 1);
        LocalDate to = LocalDate.of(year.getValue(), 12, 1);

        if (month != null) {
            from = from.withMonth(month.getValue());
            to = to.withMonth(month.getValue());
        }

        if (date != null) {
            from = from.withDayOfMonth(1);
            to = to.withDayOfMonth(date);
        } else {
            from = from.withDayOfMonth(1);
            to = to.with(TemporalAdjusters.lastDayOfMonth());
        }
        List<TransactionSummary> enities = repository.summary(from, to);

        return enities;
    }
}
