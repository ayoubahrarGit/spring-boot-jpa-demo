package com.ensat.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.demo.entities.Produit;
import com.ensat.demo.repositories.ProduitRepository;

@Service
public class ProduitService implements ICrudService<Produit>{
	@Autowired
	private ProduitRepository produitRepository;
	
//	@Autowired
//	public void setProduitRepository(ProduitRepository productRepository) {
//		this.produitRepository = productRepository;
//	}

	
	@Override
	public void save(Produit entity) {
		produitRepository.save(entity);
	}

	@Override
	public void delete(Produit entity) {
		produitRepository.delete(entity);
		
	}

	@Override
	public Optional<Produit> find(int id) {
		return produitRepository.findById(id);
	}

	public Optional<Produit> find(String name) {
		return produitRepository.findByName(name);
	}
	public boolean exist(String name){
		return produitRepository.existsByName(name);
	}
	@Override
	public Iterable<Produit> all() {
		return produitRepository.findAll();
	}
	
	public int count(){
		return (int) produitRepository.count();
			
	}
}
