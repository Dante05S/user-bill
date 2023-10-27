package com.user.bill.userbill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BaseService<E, ID, R extends CrudRepository<E, ID>> implements IBaseService<E, ID> {

    @Autowired
    private R repository;

    @Transactional
    @Override
    public E create(E entity) {
        return repository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<E> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public E get(ID id) {
        E entity = repository.findById(id).orElse(null);
        if (entity == null) {
            throw new RuntimeException();
        }
        return entity;
    }

    @Transactional
    @Override
    public E update(ID id, E entity) {
        this.get(id);
        return repository.save(entity);
    }

    @Transactional
    @Override
    public void delete(ID id) {
        this.get(id);
        repository.deleteById(id);
    }
    
}
