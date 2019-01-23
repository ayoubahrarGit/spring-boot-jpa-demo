package com.ensat.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.demo.entities.Produit;
import com.ensat.demo.repositories.ProduitRepository;

@Service
public class ProduitService {
	
	@Autowired
	private ProduitRepository productRepository;
	
	public void addproduct(Produit p){
		productRepository.save(p);
	}
}
