package com.ensat.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ensat.demo.entities.Categorie;

public interface CategorieRepository extends CrudRepository<Categorie, Integer> {
	
	
	public Optional<Categorie> findByName(String name);
	public boolean existsByName(String name);
}
