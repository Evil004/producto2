package org.example.producto2.controller;

import org.example.producto2.models.dao.RoleDAOImpl;
import org.example.producto2.models.dao.UsuarioDAOImpl;
import org.example.producto2.models.entity.Role;
import org.example.producto2.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Controller
public class RegisterController {
    @Autowired
    private
    UsuarioDAOImpl UsuarioService;

    @Autowired
    RoleDAOImpl RolService;

    @GetMapping("/register")
    public String registerForm(Model model) {

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", RolService.findAll());

        return "registerForm";
    }

    @PostMapping(value = "/register", consumes = "application/x-www-form-urlencoded\n")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> registerSubmit(@ModelAttribute Usuario usuario, @RequestParam("roles") String rolesIds
    ) {

        Set<Role> roles = new HashSet<>();


        for (String roleId : rolesIds.split(",")) {
            roles.add(RolService.findById(Long.parseLong(roleId)));
        }
        usuario.setRolesAssociated(roles);


        UsuarioService.save(usuario);


        return ResponseEntity.ok("POST request successful");

    }

}
