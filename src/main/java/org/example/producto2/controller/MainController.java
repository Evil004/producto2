package org.example.producto2.controller;

import org.example.producto2.models.dao.MenuDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    MenuDAOImpl menusService;

    @GetMapping("/")
    public String showHome(Model model) {
        model.addAttribute("menus", menusService.findAll());


        return "home";
    }

}
