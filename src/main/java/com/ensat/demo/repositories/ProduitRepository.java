package com.ensat.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ensat.demo.entities.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer> {
	
	public Optional<Produit> findByName(String name);
	public boolean existsByName(String name);
	
}
