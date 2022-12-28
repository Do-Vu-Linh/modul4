package com.example.demo1.service;

import com.example.demo1.model.SmartPhone;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "A")
public interface ISmartphoneService {
    Iterable<SmartPhone> findAll();
    Optional<SmartPhone> findById(Long id);
    SmartPhone save(SmartPhone smartPhone);
    void remove(Long id);
}
