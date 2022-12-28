package com.example.demo1.repository;

import com.example.demo1.model.SmartPhone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICRUDRepository extends CrudRepository<SmartPhone,Long>{
}
