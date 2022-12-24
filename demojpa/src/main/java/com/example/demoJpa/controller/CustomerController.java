package com.example.demoJpa.controller;

import com.example.demoJpa.model.Customer;
import com.example.demoJpa.model.Gender;
import com.example.demoJpa.service.CustomerService;
import com.example.demoJpa.service.GenderService;
import com.example.demoJpa.service.ICustomerService;
import com.example.demoJpa.service.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    public IGenderService genderService;
    @Autowired
    public ICustomerService customerService;
    @Autowired
    public HttpSession httpSession;

    @GetMapping
    public ModelAndView list(@CookieValue(value = "test",defaultValue = "0") Long counter, HttpServletResponse response) {

//        test Aspect
        System.out.println("demo123");
//        Test Cookie Value
        ++counter;
        Cookie cookie = new Cookie("test",counter.toString());
        cookie.setMaxAge(60);
        response.addCookie(cookie);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customers", customerService.findAll());
        modelAndView.addObject("cookieTest",cookie);
        return modelAndView;
    }

    @PostMapping(value = "/find")
    public ModelAndView findname(@RequestParam("name") String name) {
        try {
            ModelAndView modelAndView = new ModelAndView("list");
            modelAndView.addObject("customers", customerService.findname(name));
            return modelAndView;
        } catch (Exception e) {
            e.printStackTrace();

        } return new ModelAndView("redirect:/customers");
    }

    @ModelAttribute("customer")
    public Customer customer() {
        return new Customer();
    }

    @ModelAttribute("gender")
    public List<Gender> gender() {
        return genderService.findAll();
    }

    @GetMapping("/createForm")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("gender", genderService.findAll());

        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(Customer customer) {
        customerService.save(customer);
        httpSession.setAttribute("customer", customer);
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        return modelAndView;

    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCustomer(@PathVariable("id") Long id) {
        customerService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editCustomerForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }
    @GetMapping("/viewsession")
    public ModelAndView viewsession ( ){
        ModelAndView modelAndView = new ModelAndView("/create");
        Customer customer = (Customer) httpSession.getAttribute("customer");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

}