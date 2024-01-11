package org.example.producto2.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String registerForm(){
        return "registerForm";
    }

    @Bean
    @PostMapping("/register")
    public String registerSubmit(){

        return "registerSubmit";
    }

}
