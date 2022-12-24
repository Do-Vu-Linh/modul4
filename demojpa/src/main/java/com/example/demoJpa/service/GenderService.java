package com.example.demoJpa.service;

import com.example.demoJpa.model.Gender;
import com.example.demoJpa.repository.IGenderRepository;
import org.hibernate.boot.model.naming.Identifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class GenderService extends IGenderService {
    public GenderService() {
        super();
    }
@Autowired
public IGenderRepository iGenderRepository;
    @Override
    public List<Gender> findAll() {
        return (List<Gender> )iGenderRepository.findAll();
    }

    @Override
    public Gender findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void save(Gender gender) {
        super.save(gender);
    }

    @Override
    public void remove(Long id) {
        super.remove(id);
    }
}
