package com.enigma.restservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CommonService<E, ID> {

    public E save(E entity);

    public E removeById(ID id);

    public E findById(ID id);

    public Page<E> findAll(E entity, int page, int size, Sort.Direction sort);
}
