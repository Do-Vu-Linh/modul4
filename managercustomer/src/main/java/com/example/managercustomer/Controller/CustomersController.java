package com.example.managercustomer.Controller;

import com.example.managercustomer.Service.CustomerService;
import com.example.managercustomer.model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")

public class CustomersController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/list")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("customers", customerService.findallCustomers());
        return modelAndView;
    }
    @PostMapping (value = "/demo/{number}")
 public  ModelAndView hello (@PathVariable("number") int number) {
        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("customers2", new Customers(1L,"Test","emo","vn"));
    return modelAndView;
    }


}