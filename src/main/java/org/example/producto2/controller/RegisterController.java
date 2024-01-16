package org.example.producto2.controller;

import org.example.producto2.models.dao.UsuarioDAO;
import org.example.producto2.models.dao.UsuarioDAOImpl;
import org.example.producto2.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class RegisterController {
    @Autowired
    private
    UsuarioDAOImpl UsuarioService;
    @GetMapping("/register")
    public String registerForm(Model model){

        model.addAttribute("usuario", new Usuario());

        return "registerForm";
    }

    @PostMapping(value = "/register", consumes = "application/x-www-form-urlencoded\n")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> registerSubmit(@ModelAttribute Usuario usuario) {

        UsuarioService.save(usuario);

        return ResponseEntity.ok("POST request successful");

    }

}
