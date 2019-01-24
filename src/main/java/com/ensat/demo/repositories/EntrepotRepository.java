package com.ensat.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ensat.demo.entities.Entrepot;

public interface EntrepotRepository extends CrudRepository<Entrepot, Integer> {
	
	public Optional<Entrepot> findByName(String name);
}
