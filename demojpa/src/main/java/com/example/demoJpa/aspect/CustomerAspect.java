package com.example.demoJpa.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class CustomerAspect {
    @Before(value = "executeController()")
    public void executeController213() {
        System.out.println("before demo");
    }
    @Pointcut(value = "within(com.example.demoJpa.controller.*)")
    public void executeController() {
    }

    ;

    @Pointcut(value = "execution(public * com.example.demoJpa.service.CustomerService.findname(..))")
    public void executeController2() {
    }


}
