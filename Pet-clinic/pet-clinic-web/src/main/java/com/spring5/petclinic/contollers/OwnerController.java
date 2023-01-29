package com.spring5.petclinic.contollers;

import com.spring5.petclinic.model.Owner;
import com.spring5.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    @GetMapping({"","/index","/index.html"})
    public String showListOwner(Model model){
        Set<Owner> owners = ownerService.findALl();
        model.addAttribute("owners", owners);
        return "owners/index";
    }
}
