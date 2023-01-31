package com.spring5.petclinic.contollers;

import com.spring5.petclinic.model.Vet;
import com.spring5.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping({"/vets","/vets.html"})
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"","/index","/index.html"})
    public String showListVet(Model model){
        Set<Vet> vets = vetService.findALl();
        model.addAttribute("vets", vets);
        return "vets/index";
    }
}
