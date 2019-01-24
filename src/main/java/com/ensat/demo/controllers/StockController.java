package com.ensat.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ensat.demo.entities.Stock;
import com.ensat.demo.services.StockService;

@Controller
public class StockController {
	StockService stockService = new StockService();

	@Autowired
	public void setstockService(StockService stockService) {
		this.stockService = stockService;
	}
	
	@GetMapping("/stocks")
	public String stocks(Model model){
		model.addAttribute("stocks",stockService.all());
		return "stock/index";
	}
	@GetMapping("/stocks/add")
	public String stockAdd(){
		return "stock/form";
	}
	
	@PostMapping("stocks/save")
	public String addstock(Stock stock){
		stockService.save(stock);
		return "redirect:/stocks";
	}
	@GetMapping("/stocks/update/{name}")
	public String updatestock(@PathVariable String name ,Model model){
		model.addAttribute("stock",stockService.find(name).get());
		return "stock/form";
	}
	@GetMapping("/stocks/detail/{name}")
	public String detailstock(Model model,@PathVariable String name){
		model.addAttribute("stock",stockService.find(name).get());
		return "stock/view";
	}
	@DeleteMapping("/stocks/delete/{name}")
	public String deletestock(@PathVariable String name){
		stockService.delete(stockService.find("name").get());
		return "stock/index";
	}
}
