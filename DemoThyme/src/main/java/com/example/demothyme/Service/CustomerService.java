package com.example.demothyme.Service;

import com.example.demothyme.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void save (Customer customer);
    public Customer findbyid(int id);
    void update(int id,Customer customer);
    void remove(int id);
}
