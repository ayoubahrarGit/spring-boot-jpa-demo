package com.ensat.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ensat.demo.entities.Categorie;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Integer> {
	
	
	public Optional<Categorie> findByName(String name);
	public boolean existsByName(String name);
}
