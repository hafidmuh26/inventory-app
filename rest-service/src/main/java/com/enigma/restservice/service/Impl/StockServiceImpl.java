package com.enigma.restservice.service.Impl;

import com.enigma.restservice.entity.classentity.Stock;
import com.enigma.restservice.exception.EntityNotFoundException;
import com.enigma.restservice.repositories.StockRepository;
import com.enigma.restservice.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StockServiceImpl implements IService<Stock> {

    @Autowired
    private StockRepository stockRepository;


    @Override
    public Stock save(Stock entity) {
        return stockRepository.save(entity);
    }

    @Override
    public Stock removeById(Integer id) {
        Stock entity = findById(id);
        stockRepository.delete(entity);
        return entity;
    }

    @Override
    public Stock findById(Integer id) {
        return stockRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<Stock> findAll(Stock entity, int page, int size, Sort.Direction direction) {
        Sort s = Sort.Direction.DESC.equals(direction) ? Sort.by(direction, "id").descending() : Sort.by("id");

        ExampleMatcher matcher = ExampleMatcher.matchingAll().
                withIgnoreCase().
                withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        return stockRepository.findAll(Example.of(entity, matcher), PageRequest.of(page, size, s));
    }
}
