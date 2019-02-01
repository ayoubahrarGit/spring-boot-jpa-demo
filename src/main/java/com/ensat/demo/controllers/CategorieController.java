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
		System.out.println("********************* "+categorieService.count());
		model.addAttribute("categories",categorieService.all());
		return "categorie/index";
	}
	@GetMapping("/categories/add")
	public String categorieAdd(Model model){
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("option", "saveAdd");
		return "categorie/form";
	}
	
	@PostMapping("categories/saveAdd")
	public String addCategorie(Categorie categorie,Model model){
		// TODO : check if name exists
		System.out.println(categorie.getName());
		//Categorie c = categorieService.find(categorie.getName()).get();

		if(categorieService.exist(categorie.getName())==false){
			categorieService.save(categorie);
			return "redirect:/categories";
		}
		else{
			model.addAttribute("errorMessage", "Nom categorie deja existant");
			return "categorie/error";
		}
	}
	@PostMapping("categories/saveUpdate")
	public String updateCategorie(Categorie categorie,Model model){
		System.out.println(categorie.getName());
		//Categorie c = categorieService.find(categorie.getName()).get();
			categorieService.save(categorie);
			return "redirect:/categories";
		
	}
	@GetMapping("/categories/update/{name}")
	public String updateCategorie(@PathVariable String name ,Model model){
		model.addAttribute("categorie",categorieService.find(name).get());
		model.addAttribute("option","saveUpdate");
		return "categorie/form";
	}
	@GetMapping("/categories/detail/{name}")
	public String detailCategorie(Model model,@PathVariable String name){
		model.addAttribute("categorie",categorieService.find(name).get());
		return "categorie/view";
	}
	@DeleteMapping("/categories/delete/{name}")
	public String deleteCategorie(@PathVariable String name){
		// TODO : check if it's a parent row => delete child rows
		System.err.println(name);
		categorieService.delete(categorieService.find(name).get());
		return "redirect:/categories";
	}
}
