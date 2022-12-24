package com.example.demoJpa.repository;

import com.example.demoJpa.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface ICustomerRepository extends CrudRepository<Customer,Long> {
    @Query(value = "select * from customers where lastName like :name",nativeQuery = true)
    List<Customer> findNameCus(@Param("name") @Nullable String name);

}
