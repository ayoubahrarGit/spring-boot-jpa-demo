package com.ensat.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.demo.entities.Categorie;
import com.ensat.demo.repositories.CategorieRepository;

@Service
public class CategorieService implements ICrudService<Categorie> {
	
	@Autowired
	private CategorieRepository categorieRepository;
//	@Autowired
//		public void setCategorieRepository(CategorieRepository categorieRepository) {
//		this.categorieRepository = categorieRepository;
//	}

	@Override
	public void save(Categorie entity) {
		categorieRepository.save(entity);
	}

	@Override
	public void delete(Categorie entity) {
		categorieRepository.delete(entity);
	}

	@Override
	public Optional<Categorie> find(int id) {
		return categorieRepository.findById(id);
	}

	public Optional<Categorie> find(String name) {
		return categorieRepository.findByName(name);
	}
	
	public boolean exist(String name){
		return categorieRepository.existsByName(name);
	}
	@Override
	public Iterable<Categorie> all() {
		return categorieRepository.findAll();
	}
	
	public int count(){
		return (int) categorieRepository.count();		
	}	
}
