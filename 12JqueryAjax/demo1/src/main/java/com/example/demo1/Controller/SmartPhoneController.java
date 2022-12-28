package com.example.demo1.Controller;

import com.example.demo1.model.SmartPhone;
import com.example.demo1.service.ISmartphoneService;
import com.example.demo1.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/smartphones")
public class SmartPhoneController {
    @Autowired
    public ISmartphoneService b;
    @PostMapping
    public ResponseEntity<SmartPhone> createSmartphone(@RequestBody SmartPhone smartphone) {

        return new ResponseEntity<>(b.save(smartphone), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ResponseEntity<SmartPhone>

}
