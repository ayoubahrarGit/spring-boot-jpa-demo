package com.ensat.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ensat.demo.entities.Entrepot;

@Repository
public interface EntrepotRepository extends CrudRepository<Entrepot, Integer> {
	
	public Optional<Entrepot> findByName(String name);
	public boolean existsByName(String name);
}
