package com.example.aeroparkerCC.controllers;


import com.example.aeroparkerCC.entities.Customer;
import com.example.aeroparkerCC.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationFormController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/registration")
    public String index(Model model){
        Customer c = new Customer();
        model.addAttribute("c", c);
        return "RegistrationForm";
    }

    @PostMapping("/successPage")
    public String signUpSuccess(@ModelAttribute("c") Customer c, Model model){
        if (customerService.emailExists(c.getEmail_address())){  //if email has been used before, go back to sign up page with an alert
            model.addAttribute("emailUsed", true); //attribute added which initiates alert box function
            index(model);
            return "RegistrationForm";
        } else {
            customerService.addCustomer(c);
            return "SignedIn";
        }
    }
}
