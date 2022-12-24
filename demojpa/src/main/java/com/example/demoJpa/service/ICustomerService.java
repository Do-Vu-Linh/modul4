package com.example.demoJpa.service;

import com.example.demoJpa.model.Customer;

import java.util.List;

public abstract class ICustomerService implements ICRUDCustomer<Customer> {
    @Override
    public abstract List<Customer> findAll() ;

    @Override
    public abstract Customer findById(Long id) ;

    @Override
    public abstract void save(Customer customer) ;

    @Override
    public void remove(Long id) {

    }
    public abstract List <Customer> findname( String name);
}
