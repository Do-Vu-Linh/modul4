package com.example.session_cookie.controller;

import com.example.session_cookie.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Controller
//@SessionAttributes("counter")
public class CounterController {
    @ModelAttribute("counter")
    public Counter setupCounter(){
        return new Counter();
    }
    @GetMapping("test")
    public String get(@ModelAttribute("counter") Counter counter){
        counter.increment();
        return "/index";
    }
}
