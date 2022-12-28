package com.example.demo.controller;

import com.example.demo.model.Customers;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    public ICustomerService iCustomerService;
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @GetMapping
    public ResponseEntity<Iterable<Customers>> findAllCustomers() {
        List<Customers> customers = (List<Customers>) iCustomerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(customers, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Customers> findById(@PathVariable Long id) {
        Optional<Customers> customers = iCustomerService.findById(id);
        if (!customers.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customers.get(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Customers> save(@RequestBody Customers customers) {
        return new ResponseEntity<>(iCustomerService.save(customers), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Customers> update(@PathVariable Long id, @RequestBody Customers customers) {
        Optional<Customers> customersOptional = iCustomerService.findById(id);
        if (!customersOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            customers.setId(customersOptional.get().getId());
            return new ResponseEntity<>(iCustomerService.save(customers), HttpStatus.OK);

        }

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<Customers> customers = iCustomerService.findById(id);
        if (!customers.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        } else {  iCustomerService.remove(id);
            return new ResponseEntity<>(customers.get(),HttpStatus.NO_CONTENT);

        }
    }

}

