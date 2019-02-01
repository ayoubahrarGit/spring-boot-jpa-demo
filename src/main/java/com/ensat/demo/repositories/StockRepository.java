package com.ensat.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ensat.demo.entities.Entrepot;
import com.ensat.demo.entities.Produit;
import com.ensat.demo.entities.Stock;

public interface StockRepository extends CrudRepository<Stock, Integer> {
	
	 @Query("SELECT SUM(s.quantite) from Stock s")
	 Integer getSum();
	 
	 public boolean existsByEntrepot(Entrepot e);
	 public boolean existsByProduit(Produit e);
	 
	 public Stock findByEntrepotAndProduit(Entrepot e,Produit p);

}
