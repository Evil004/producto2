package org.example.producto2.controller;

import org.example.producto2.models.dao.ProductoDAOImpl;
import org.example.producto2.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/productos/{id}")
    public String pedidos(Model model, @PathVariable(value = "id") final int id) {
        model.addAttribute("producto", ProductService.findByID(id));
        return "vista_producto";
    }

    @GetMapping("/productos/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new Producto());
        return "create_product";
    }

    @PostMapping("/productos/create")
    public String newProduct(@ModelAttribute Producto product) {
        ProductService.save(product);
        return "redirect:/productos/" + product.getId();
    }


    @GetMapping("/productos/update/{id}")
    public String updateProduct(Model model, @PathVariable(value = "id") final int id) {

        Producto producto = ProductService.findByID(id  );

        model.addAttribute("product", producto);
        return "update_product";
    }

    @PostMapping("/productos/update/{id}")
    public String updateProductPost(@ModelAttribute Producto producto, @PathVariable(value = "id") final String id) {

        ProductService.update(producto);
        return "redirect:/productos/" + id;
    }

    @DeleteMapping("/productos/delete/{id}")
    public String deleteProduct(@PathVariable(value = "id") final int id) {
        ProductService.delete(id);
        return "redirect:/productos";
    }

}
