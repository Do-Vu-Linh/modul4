package com.example.demoJpa.repository;

import com.example.demoJpa.model.Gender;
import org.springframework.data.repository.CrudRepository;

public interface  IGenderRepository extends CrudRepository <Gender,Long> {

}

