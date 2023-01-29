package com.spring5.petclinic.services;

import java.util.Set;

public interface CrudService<T,ID> {

    T save(T object);

    T findById(ID id);

    Set<T> findALl();

    void deleteById(ID id);

    void delete(T object);
}
