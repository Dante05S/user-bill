package com.user.bill.userbill.service;

public interface IBaseService<E, ID> {
    E create(E entity);
    E update(ID id, E entity, String messageError);
    void delete(ID id, String messageError);
    Iterable<E> getAll();
    E get(ID id, String messageError);
}
