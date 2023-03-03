package com.my.controller;

import com.my.entity.User;
import com.my.model.CrmUser;
import com.my.service.RoleService;
import com.my.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;
    private final RoleService roleService;

    private Map<String,String> roles;

    @Autowired
    public RegistrationController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    protected void loadRoles(){
        roles = roleService.getStringRoles();
    }


    @GetMapping("/showRegistrationForm")
    public String showRegistrationForm(Model model) {
        model.addAttribute("crmUser", new CrmUser());
        model.addAttribute("roles", roles);
        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("crmUser") CrmUser crmUser,
            BindingResult bindingResult,
            Model model) {

        String userName = crmUser.getUserName();


        if (bindingResult.hasErrors()) {

            model.addAttribute("roles", roles);
            model.addAttribute("registrationError", "User cannot be created.");

            return "registration-form";
        }

        User existing = userService.findByUserName(userName);

        if (existing != null) {

            model.addAttribute("roles", roles);
            model.addAttribute("registrationError", "User name already exists.");

            return "registration-form";
        }

        userService.save(crmUser);


        return "registration-confirmation";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

    }
}
