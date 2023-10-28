package com.user.bill.userbill.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.user.bill.userbill.helpers.exceptions.NotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class BaseService<E, ID, R extends CrudRepository<E, ID>> {
    private R repository;

    @Transactional
    public E create(E entity) {
        return repository.save(entity);
    }

    @Transactional(readOnly = true)
    public Iterable<E> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public E get(ID id, String messageError) {
        E entity = repository.findById(id).orElse(null);
        if (entity == null) {
            throw new NotFoundException(messageError);
        }
        return entity;
    }

    @Transactional
    public E update(ID id, E entity, String messageError) {
        this.get(id, messageError);
        return repository.save(entity);
    }

    @Transactional
    public void delete(ID id, String messageError) {
        this.get(id, messageError);
        repository.deleteById(id);
    }
    
}
