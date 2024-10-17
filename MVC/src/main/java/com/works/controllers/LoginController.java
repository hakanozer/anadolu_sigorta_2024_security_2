package com.works.controllers;

import com.works.entities.Customer;
import com.works.services.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginController {

    final LoginService loginService;

    @GetMapping("")
    public String login(){
        return "login";
    }

    @PostMapping("login")
    public String loginPost(@Valid Customer customer, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
           List<FieldError> errors = bindingResult.getFieldErrors();
           model.addAttribute("errors", errors);
        }else {
            model.addAttribute("name", customer.getName());
            boolean status = loginService.login(customer.getEmail(), customer.getPassword());
            if(status) {
                return "redirect:/dashboard";
            }
        }
        return "login";
    }


}
