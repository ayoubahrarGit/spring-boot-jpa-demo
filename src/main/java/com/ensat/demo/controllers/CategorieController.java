package com.ensat.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ensat.demo.entities.Categorie;
import com.ensat.demo.services.CategorieService;

@Controller
public class CategorieController {
	
	CategorieService categorieService = new CategorieService();

	@Autowired
	public void setCategorieService(CategorieService categorieService) {
		this.categorieService = categorieService;
	}
	
	@GetMapping("/categories")
	public String Categories(Model model){
		model.addAttribute("categories",categorieService.all());
		return "categorie/index";
	}
	@GetMapping("/categories/add")
	public String categorieAdd(){
		return "categorie/form";
	}
	
	@PostMapping("categories/save")
	public String addCategorie(Categorie categorie){
		categorieService.save(categorie);
		return "redirect:/categories";
	}
	@GetMapping("/categories/update/{name}")
	public String updateCategorie(@PathVariable String name ,Model model){
		model.addAttribute("categorie",categorieService.find(name));
		return "categorie/form";
	}
	@GetMapping("/categories/detail/{name}")
	public String detailCategorie(Model model,@PathVariable String name){
		model.addAttribute("categorie",categorieService.find(name));
		return "categorie/view";
	}
	@DeleteMapping
	public String deleteCategorie(@PathVariable String name){
		categorieService.delete(categorieService.find("name").get());
		return "categorie/index";
	}
	
}
