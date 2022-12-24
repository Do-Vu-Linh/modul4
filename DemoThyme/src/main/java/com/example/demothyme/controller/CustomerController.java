package com.example.demothyme.controller;

import com.example.demothyme.Service.CustomerService;
import com.example.demothyme.Service.Ipm.CustomerServiceIpm;
import com.example.demothyme.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.constants.OPSize.INDEX;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    private String index(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("demo", customers);
        return "/index";

    }

    @GetMapping("/{id}/delete")
    private String delete(@PathVariable("id") int id, RedirectAttributes redirect) {
        customerService.remove(id);
//        cach tao thong bao success voi addFlashAttribute
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customers";
    }


    @ModelAttribute("customer")
    public  Customer customer () {
        return new Customer();
    }
//    @ModelAttribute("customer") gửi addAttribute "customer" đến tất cả các HTML nếu trong phương thức không có attributes gửi đi.



        @GetMapping("/create")
        private String create(Model model) {
            model.addAttribute("customer",new Customer());
    //nếu có @ModelAttribute("customer") thì không cần phải new Customer()
            return "/create";
        }

    @PostMapping("/save")
    private String save(Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";

    }

    @GetMapping("/{id}/edit")
    private String edit(@PathVariable("id") int id, Model model) {
        Customer customer = customerService.findbyid(id);
        model.addAttribute("customer", customer);
        return "/create";
    }

    @GetMapping(value = "/{id}/view")
//    cách 1:
//    private ModelAndView modelAndView(@PathVariable("id") int id) {
//        Customer customer = customerService.findbyid(id);
//        ModelAndView modelAndView = new ModelAndView("/view");
//        modelAndView.addObject("customer", customer);
//        return modelAndView;
//    }
//    cách 2 :
    private String view (@PathVariable("id") int id, Model model) {
        Customer customer = customerService.findbyid(id);
        model.addAttribute("customer", customer);
        return "/create";

    }
}
