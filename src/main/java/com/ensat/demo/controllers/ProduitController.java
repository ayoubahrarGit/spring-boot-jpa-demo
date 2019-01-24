package com.ensat.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ensat.demo.entities.Produit;
import com.ensat.demo.services.ProduitService;

@Controller
public class ProduitController {
	ProduitService produitService = new ProduitService();

	@Autowired
	public void setProduitService(ProduitService produitService) {
		this.produitService = produitService;
	}
	
	@GetMapping("/produits")
	public String Produits(Model model){
		model.addAttribute("produits",produitService.all());
		return "produit/index";
	}
	@GetMapping("/produits/add")
	public String ProduitAdd(){
		return "produit/form";
	}
	
	@PostMapping("produits/save")
	public String addProduit(Produit Produit){
		produitService.save(Produit);
		return "redirect:/produits";
	}
	@GetMapping("/produits/update/{name}")
	public String updateProduit(@PathVariable String name ,Model model){
		model.addAttribute("produit",produitService.find(name).get());
		return "produit/form";
	}
	@GetMapping("/produits/detail/{name}")
	public String detailProduit(Model model,@PathVariable String name){
		model.addAttribute("produit",produitService.find(name).get());
		return "produit/view";
	}
	@DeleteMapping("/produits/delete/{name}")
	public String deleteProduit(@PathVariable String name){
		produitService.delete(produitService.find("name").get());
		return "produit/index";
	}
}
