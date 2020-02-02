package com.example.motorshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String sayHello() {
        return "<h1>Hello World!</h1> <p>Okay it works now. Okay</p>";
    }

    @RequestMapping("/again")
    public String sayHelloAgain() {
        return "<h1>Hello World!</h1> <p>Auto update works again</p>";
    }

}
