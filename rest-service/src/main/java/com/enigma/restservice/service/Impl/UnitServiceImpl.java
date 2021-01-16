package com.enigma.restservice.service.Impl;

import com.enigma.restservice.entity.classentity.Unit;
import com.enigma.restservice.exception.EntityNotFoundException;
import com.enigma.restservice.repositories.UnitRepository;
import com.enigma.restservice.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UnitServiceImpl implements IService<Unit> {

    @Autowired
    private UnitRepository repository;

    @Override
    public Unit save(Unit entity) {
        return repository.save(entity);
    }

    @Override
    public Unit removeById(Integer id) {
        Unit entity = findById(id);
        repository.delete(entity);

        return entity;
    }

    @Override
    public Unit findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException();
        });
    }

    @Override
    public Page<Unit> findAll(Unit entity, int page, int size, Sort.Direction sort) {
        Sort s = Sort.Direction.DESC.equals(sort) ? Sort.by(sort, "id").descending() : Sort.by("id");

        ExampleMatcher matcher = ExampleMatcher.matchingAll().
                withIgnoreCase().
                withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        return repository.findAll(Example.of(entity, matcher), PageRequest.of(page, size, s));
    }
}


