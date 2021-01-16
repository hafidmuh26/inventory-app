package com.enigma.restservice.service.Impl;

import com.enigma.restservice.exception.EntityNotFoundException;
import com.enigma.restservice.service.CommonService;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class CommonServiceImpl<E, ID> implements CommonService<E, ID> {

    protected abstract JpaRepository<E, ID> getRepository();

    @Override
    public E save(E entity) {
        return getRepository().save(entity);
    }

    @Override
    public E removeById(ID id) {
        E entity = findById(id);
        getRepository().delete(entity);

        return entity;
    }

    @Override
    public E findById(ID id) {
        return getRepository().findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<E> findAll(E entity, int page, int size, Sort.Direction direction) {
        Sort sort = Sort.Direction.DESC.equals(direction) ? Sort.by(direction, "id").descending() : Sort.by("id");
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        return getRepository().findAll(Example.of(entity, matcher), PageRequest.of(page, size, sort));
    }
}


