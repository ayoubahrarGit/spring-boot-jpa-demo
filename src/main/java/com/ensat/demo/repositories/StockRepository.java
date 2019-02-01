package com.ensat.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ensat.demo.entities.Entrepot;
import com.ensat.demo.entities.Produit;
import com.ensat.demo.entities.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Integer> {
	
	 @Query("SELECT SUM(s.quantite) from Stock s")
	 Integer getSum();
	 
	 public boolean existsByEntrepotAndProduit(Entrepot e,Produit p);
	 
	 public Stock findByEntrepotAndProduit(Entrepot e,Produit p);

}
