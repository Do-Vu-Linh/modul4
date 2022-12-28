package com.example.demo1.service;

import com.example.demo1.model.SmartPhone;
import com.example.demo1.repository.ICRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service(value = "b")
public class SmartPhoneService implements ISmartphoneService{
    @Autowired
    public ICRUDRepository icrudRepository;
    @Override
    public Iterable<SmartPhone> findAll() {
        return icrudRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return icrudRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return icrudRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        icrudRepository.deleteById(id);

    }
}
