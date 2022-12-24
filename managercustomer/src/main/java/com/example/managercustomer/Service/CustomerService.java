package com.example.managercustomer.Service;

import com.example.managercustomer.model.Customers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component(value = "customerService")

public class CustomerService {
    private  static  final List<Customers> customers;
    static {
        customers = new ArrayList<>();
        customers.add(new Customers(1L,"linh","vulinh@gmail.com","vietnam"));
        customers.add(new Customers(1L,"nam","nam@gmail.com","Hanoi"));
        customers.add(new Customers(1L,"son","son@gmail.com","HCM"));
    }
public List<Customers> findallCustomers() {
        return customers;
}
    
}
