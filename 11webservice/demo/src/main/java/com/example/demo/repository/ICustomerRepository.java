package com.example.demo.repository;

import com.example.demo.model.Customers;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository extends PagingAndSortingRepository<Customers,Long> {
}
