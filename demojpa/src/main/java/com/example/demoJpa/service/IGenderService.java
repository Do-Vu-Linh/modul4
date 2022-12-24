package com.example.demoJpa.service;

import com.example.demoJpa.model.Gender;

import java.util.List;

public abstract class IGenderService implements ICRUDCustomer <Gender> {
    public IGenderService() {
        super();

    }

    @Override
    public List<Gender> findAll() {
        return null;
    }

    @Override
    public Gender findById(Long id) {
        return null;
    }

    @Override
    public void save(Gender gender) {

    }

    @Override
    public void remove(Long id) {

    }
}
