package com.ensat.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ensat.demo.entities.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Integer> {

}
