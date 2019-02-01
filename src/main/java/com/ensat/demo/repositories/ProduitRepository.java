package com.ensat.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ensat.demo.entities.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Integer> {
	
	public Optional<Produit> findByName(String name);
	public boolean existsByName(String name);
	
}
