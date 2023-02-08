package com.my.mvc;

import com.my.mvc.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @RequestMapping("/showForm")
    public String showForm(Model model){

        Student student = new Student();
        student.setFirstName("G");
        student.setLastName("Tate");

        model.addAttribute("student", student);

        model.addAttribute("theCountryOptions", countryOptions);

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student){

        System.out.println("student: " +
                student.getFirstName() +
                " " + student.getLastName());

        System.out.println(Arrays.toString(student.getOperatingSystems()));

        return "student-confirmation";
    }

}
