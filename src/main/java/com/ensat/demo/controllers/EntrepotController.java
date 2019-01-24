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

@Controller
public class EntrepotController {

	EntrepotService entreportService = new EntrepotService();

	@Autowired
	public void setEntrepotService(EntrepotService entreportService) {
		this.entreportService = entreportService;
	}
	
	@GetMapping("/entrepots")
	public String Entrepots(Model model){
		model.addAttribute("entrepots",entreportService.all());
		return "entrepot/index";
	}
	@GetMapping("/entrepots/add")
	public String entrepotAdd(){
		return "entrepot/form";
	}
	
	@PostMapping("entrepots/save")
	public String addEntrepot(Entrepot entrepot){
		entreportService.save(entrepot);
		return "redirect:/entrepots";
	}
	@GetMapping("/entrepots/update/{name}")
	public String updateEntrepot(@PathVariable String name ,Model model){
		model.addAttribute("entrepot",entreportService.find(name).get());
		return "entrepot/form";
	}
	@GetMapping("/entrepots/detail/{name}")
	public String detailEntrepot(Model model,@PathVariable String name){
		model.addAttribute("entrepot",entreportService.find(name).get());
		return "entrepot/view";
	}
	@DeleteMapping("/entrepots/delete/{name}")
	public String deleteEntrepot(@PathVariable String name){
		entreportService.delete(entreportService.find("name").get());
		return "entrepot/index";
	}
}
