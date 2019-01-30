package com.ensat.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.demo.entities.Entrepot;
import com.ensat.demo.repositories.EntrepotRepository;

@Service
public class EntrepotService implements ICrudService<Entrepot> {

	private EntrepotRepository entrepotRepository;
	@Autowired
	public void setEntrepotRepository(EntrepotRepository entrepotRepository) {
		this.entrepotRepository = entrepotRepository;
	}

	
	@Override
	public void save(Entrepot entity) {
		entrepotRepository.save(entity);
	}

	@Override
	public void delete(Entrepot entity) {
		entrepotRepository.delete(entity);
		
	}

	@Override
	public Optional<Entrepot> find(int id) {
		return entrepotRepository.findById(id);
	}

	public Optional<Entrepot> find(String name) {
		return entrepotRepository.findByName(name);
	}

	@Override
	public Iterable<Entrepot> all() {
		return entrepotRepository.findAll();
	}

	public int count(){
		return (int) entrepotRepository.count();
	}
}
