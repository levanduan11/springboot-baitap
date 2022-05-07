package com.jobhunt.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepositoty<T,ID> {
    List<T>findAll();
    T save(T t);
   Optional<T> findById(ID id);
    void delete(ID id);
}
