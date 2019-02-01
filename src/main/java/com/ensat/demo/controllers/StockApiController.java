package com.ensat.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ensat.demo.beans.StockViewBean;
import com.ensat.demo.entities.Stock;
import com.ensat.demo.services.StockService;

@RestController
public class StockApiController {

	StockService stockService = new StockService();
	
	@Autowired
	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}	

	@GetMapping(value = "/stocks/api/{entrepot}/{produit}", produces = "application/json")
	public StockViewBean stockAPI(@PathVariable String entrepot, @PathVariable String produit){
		
		Stock s = stockService.find(entrepot, produit);
		StockViewBean sv = null;
		if(s!=null)
			sv = stockService.toView(s);
		return sv;
	}
	
}
