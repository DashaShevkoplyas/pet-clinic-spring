package com.clinic.petclinicspring.controllers;

import com.clinic.petclinicspring.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
