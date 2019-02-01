package com.ensat.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ensat.demo.beans.StockViewBean;
import com.ensat.demo.entities.Entrepot;
import com.ensat.demo.entities.Produit;
import com.ensat.demo.entities.Stock;
import com.ensat.demo.services.EntrepotService;
import com.ensat.demo.services.ProduitService;
import com.ensat.demo.services.StockService;

@Controller
public class StockController {
	
	StockService stockService = new StockService();
	EntrepotService entrepotService = new EntrepotService();
	ProduitService produitService = new ProduitService();
	
	@Autowired
	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

	@Autowired
	public void setEntrepotService(EntrepotService entrepotService) {
		this.entrepotService = entrepotService;
	}

	@Autowired
	public void setProduitService(ProduitService produitService) {
		this.produitService = produitService;
	}

	@GetMapping("/stocks")
	public String stocks(Model model){
		
		model.addAttribute("stocks",stockService.toViewBean());
		model.addAttribute("stock", new StockViewBean());
		
		ArrayList<Entrepot> lEntr = (ArrayList<Entrepot>) entrepotService.all();
		model.addAttribute("entrepotList", lEntr);
		
		ArrayList<Produit> lProd = (ArrayList<Produit>) produitService.all();
		model.addAttribute("produitList", lProd);
		
		return "stock/index";
	}
	
	@PostMapping("stocks/save")
	public String editStock(StockViewBean stockView){
		Stock s = stockService.toEntity(stockView);
		stockService.save(s);
		return "redirect:/stocks";		
	}
	
	
	@DeleteMapping("/stocks/delete/{id}")
	public String deletestock(@PathVariable String id){
		stockService.delete(stockService.find(Integer.parseInt(id)).get());
		return "redirect:/stocks";
	}
}
