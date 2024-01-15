package org.example.producto2.controller;

import org.example.producto2.models.dao.ProductoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ProductosController {
    @Autowired
    private ProductoDAOImpl ProductService;

    @GetMapping("/productos")
    public String pedidos(Model model) {
        model.addAttribute("products", ProductService.findAll());
        return "productos";
    }

}
