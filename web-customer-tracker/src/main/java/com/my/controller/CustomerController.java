package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/list")
    public String customerList(
            Model model
    ){
        model.addAttribute("hi", 445L);
        return "list-customers";
    }
}
