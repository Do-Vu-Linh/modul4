package com.example.demothyme.Service.Ipm;

import com.example.demothyme.Service.CustomerService;
import com.example.demothyme.model.Customer;
import org.glassfish.jersey.internal.inject.ParamConverters;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service(value = "customerService")
public class CustomerServiceIpm implements CustomerService {
    private static  final Map<Integer,Customer> customers;
    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customers.put(2, new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customers.put(3, new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customers.put(4, new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customers.put(5, new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customers.put(6, new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        if(customer.getId() == 0) {
            customer.setId((int) (Math.random() * 10000));
        }customers.put(customer.getId(), customer);

    }

    @Override
    public Customer findbyid(int id) {
      return   customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
customers.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);

    }
}
