package com.ensat.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ensat.demo.services.CategorieService;
import com.ensat.demo.services.EntrepotService;
import com.ensat.demo.services.ProduitService;
import com.ensat.demo.services.StockService;

@Controller
public class HomeController {
	@Autowired
	CategorieService categorieService = new CategorieService();
//	@Autowired
//	public void setCategorieService(CategorieService categorieService) {
//		this.categorieService = categorieService;
//	}
	@Autowired
	ProduitService produitService = new ProduitService();
//	@Autowired
//	public void setProduitService(ProduitService produitService) {
//		this.produitService = produitService;
//	}
	@Autowired
	StockService stockService = new StockService();
	
//	@Autowired
//	public void setStockService(StockService stockService) {
//		this.stockService = stockService;
//	}
	@Autowired
	EntrepotService entrepotService = new EntrepotService();
//	@Autowired
//	public void setEntrepotService(EntrepotService entrepotService) {
//		this.entrepotService = entrepotService;
//	}
	
	
	
	@GetMapping("/")
	public String home(Model model){
		
		model.addAttribute("produits", produitService.count());
		model.addAttribute("stock", stockService.sum());
		model.addAttribute("categories", categorieService.count());
		model.addAttribute("entrepots", entrepotService.count());
		return "home";
	}	
}
 