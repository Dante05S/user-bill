package com.user.bill.userbill.service;

public interface IBaseService<E, ID> {
    E create(E entity);
    E update(ID id, E entity);
    void delete(ID id);
    Iterable<E> getAll();
    E get(ID id);
}
