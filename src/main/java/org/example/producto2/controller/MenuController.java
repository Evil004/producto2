package org.example.producto2.controller;

import org.example.producto2.models.dao.MenuDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @Autowired
    MenuDAOImpl menuRepository;

    @GetMapping("/menus")
    public String menus(Model model) {
        model.addAttribute("menus", menuRepository.findAll());
        model.addAttribute("currentPage", "menus");
        return "menus";
    }

}
