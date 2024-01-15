package org.example.producto2.controller;

import org.example.producto2.models.dao.ProductoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.producto2.models.dao.MenuDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @Autowired
    MenuDAOImpl MenuService;

    @GetMapping("/menus")
    public String menus(Model model) {
        model.addAttribute("menus", MenuService.findAll());
        return "menus";
    }

}
