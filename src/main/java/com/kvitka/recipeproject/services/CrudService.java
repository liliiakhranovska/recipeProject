package com.kvitka.recipeproject.services;

import java.util.Optional;

public interface CrudService<T, ID> {

    Iterable<T> findAll();

    Optional<T> findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
