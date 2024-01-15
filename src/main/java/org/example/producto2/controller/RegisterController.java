package org.example.producto2.controller;

import org.example.producto2.models.dao.UsuarioDAO;
import org.example.producto2.models.entity.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String registerForm(){
        return "registerForm";
    }

    @PostMapping("/registerPost")
    @ResponseStatus(HttpStatus.CREATED)
    public String registerSubmit(@RequestBody Usuario usuario) {

        return "redirect:/";
    }

}
