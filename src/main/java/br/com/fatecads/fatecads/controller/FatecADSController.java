package br.com.fatecads.fatecads.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

@Controller
public class FatecADSController {

    @GetMapping({"/", "/fatecads"})
    public String index(Model model) {
        return "index";
    }
    
}
