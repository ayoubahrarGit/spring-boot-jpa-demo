package com.ensat.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ensat.demo.entities.Entrepot;
import com.ensat.demo.services.EntrepotService;
import com.ensat.demo.services.ProduitService;

@Controller
public class EntrepotController {
	@Autowired
	EntrepotService entreportService = new EntrepotService();

//	@Autowired
//	public void setEntrepotService(EntrepotService entreportService) {
//		this.entreportService = entreportService;
//	}
	
	@GetMapping("/entrepots")
	public String Entrepots(Model model){
		model.addAttribute("entrepots",entreportService.all());
		return "entrepot/index";
	}
	@GetMapping("/entrepots/add")
	public String entrepotAdd(Model model){
		model.addAttribute("entrepot", new Entrepot());
		model.addAttribute("option", "saveAdd");
		return "entrepot/form";
	}
	
	@PostMapping("entrepots/saveAdd")
	public String addEntrepot(Entrepot entrepot,Model model){
		if(!entreportService.exist(entrepot.getName())){
			entreportService.save(entrepot);
		return "redirect:/entrepots";
		}
		else{
			model.addAttribute("errorMessage", "Nom entrepot deja existant");
			return "entrepot/error";
		}
	}
	@PostMapping("entrepots/saveUpdate")
	public String updateEntrepot(Entrepot entrepot,Model model){
		entreportService.save(entrepot);
		return "redirect:/entrepots";	
	}
	@GetMapping("/entrepots/update/{name}")
	public String updateEntrepot(@PathVariable String name ,Model model){
		model.addAttribute("entrepot",entreportService.find(name).get());
		model.addAttribute("option","saveUpdate");
		return "entrepot/form";
	}
	@GetMapping("/entrepots/detail/{name}")
	public String detailEntrepot(Model model,@PathVariable String name){
		model.addAttribute("entrepot",entreportService.find(name).get());
		return "entrepot/view";
	}
	@DeleteMapping("/entrepots/delete/{name}")
	public String deleteEntrepot(@PathVariable String name){
		entreportService.delete(entreportService.find(name).get());
		return "redirect:/entrepots";
	}
}
