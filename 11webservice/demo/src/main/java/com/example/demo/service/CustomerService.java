package com.example.demo.service;

import com.example.demo.model.Customers;
import com.example.demo.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    public ICustomerRepository iCustomerRepository;
    @Override
    public Iterable<Customers> findAll() {
      return   iCustomerRepository.findAll();
    }

    @Override
    public Optional<Customers> findById(Long id) {
      return iCustomerRepository.findById(id);

    }

    @Override
    public Customers save(Customers customers) {
        return iCustomerRepository.save(customers);
    }

    @Override
    public void remove(Long id) {

    }
}
