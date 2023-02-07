package com.my.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "hello-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "hello";
    }

    @RequestMapping("/processFormV2")
    public String processFormV2(HttpServletRequest request, Model model){

        String studentName = request.getParameter("studentName");

        String result = "Yo! " + studentName.toUpperCase();

        model.addAttribute("message", result);

        return "hello";
    }

}
