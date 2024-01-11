package org.example.producto2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/menus")
    public String menus() {
        return "menus";
    }

}
