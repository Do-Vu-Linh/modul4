package com.example.springboot18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller {
    @GetMapping("/greeting")
    public ModelAndView showGreeting(){
        return new ModelAndView("/test");
    }
}
