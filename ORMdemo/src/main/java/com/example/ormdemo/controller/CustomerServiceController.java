package com.example.ormdemo.controller;

import com.example.ormdemo.serivce.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerServiceController {
    @Autowired
    public CustomerService customerService;

    @GetMapping
    public ModelAndView modelAndView() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("customer", customerService.findAll());
        return modelAndView;
    }
}
