package com.example.demoJpa.service;

import java.util.List;

public interface ICRUDCustomer<T> {
List<T> findAll();
T findById (Long id);
void save (T t);
void remove (Long id);

}
