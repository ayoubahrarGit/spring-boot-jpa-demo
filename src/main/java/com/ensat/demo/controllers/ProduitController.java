package com.ensat.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ensat.demo.beans.ProduitViewBean;
import com.ensat.demo.entities.Categorie;
import com.ensat.demo.entities.Produit;
import com.ensat.demo.services.CategorieService;
import com.ensat.demo.services.ProduitService;

@Controller
public class ProduitController {
	ProduitService produitService = new ProduitService();
	CategorieService categorieService = new CategorieService();

	@Autowired
	public void setProduitService(ProduitService produitService) {
		this.produitService = produitService;
	}
	
	@Autowired
	public void setCategorieService(CategorieService categorieService) {
		this.categorieService = categorieService;
	}

	@GetMapping("/produits")
	public String Produits(Model model){
		model.addAttribute("produits",produitService.all());
		return "produit/index";
	}
	@GetMapping("/produits/add")
	public String ProduitAdd(Model model){
		model.addAttribute("produitVB", new ProduitViewBean());
		ArrayList<Categorie> lCat = (ArrayList<Categorie>) categorieService.all();
		model.addAttribute("categorieList", lCat);
		return "produit/form";
	}
	
	@PostMapping("produits/save")
	public String addProduit(ProduitViewBean produitVB){
		Produit p = produitVB.toProduit();
		Categorie c = categorieService.find(produitVB.getCategorie()).get();
		p.setCategorie(c);
		produitService.save(p);
		return "redirect:/produits";
	}
	@GetMapping("/produits/update/{name}")
	public String updateProduit(@PathVariable String name ,Model model){
		ProduitViewBean pVB = new ProduitViewBean();
		Produit p = produitService.find(name).get();
		pVB.fromProduit(p);
		model.addAttribute("produitVB", pVB);
		
		ArrayList<Categorie> lCat = (ArrayList<Categorie>) categorieService.all();
		model.addAttribute("categorieList", lCat);
		return "produit/form";
	}
	@GetMapping("/produits/detail/{name}")
	public String detailProduit(Model model,@PathVariable String name){
		model.addAttribute("produit",produitService.find(name).get());
		return "produit/view";
	}
	@DeleteMapping("/produits/delete/{name}")
	public String deleteProduit(@PathVariable String name){
		produitService.delete(produitService.find(name).get());
		return "redirect:/produits";
	}
}
