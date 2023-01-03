package com.example.i18n22.controller;

import com.example.i18n22.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {
    @GetMapping
//    public ModelAndView login(){
////        ModelAndView modelAndView = new ModelAndView("/view");
////        modelAndView.addObject("user",new User());
////        return modelAndView;
//    }
    public ModelAndView login(){
        return new ModelAndView("/view","user" , new User());
    }
}
