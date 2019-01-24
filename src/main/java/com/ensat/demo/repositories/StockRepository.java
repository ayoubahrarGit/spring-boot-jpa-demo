package com.ensat.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ensat.demo.entities.Stock;

public interface StockRepository extends CrudRepository<Stock, Integer> {
	
}
