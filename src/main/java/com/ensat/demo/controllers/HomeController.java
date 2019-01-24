package com.ensat.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model){
		// do smth like ((ArrayList<Produit>) new ProduitService().all()).size()
		model.addAttribute("produits", 1);
		model.addAttribute("stock", 1);
		model.addAttribute("categories", 1);
		model.addAttribute("entrepots", 1);
		return "home";
	}
	
}
 