package com.ensat.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.demo.entities.Stock;
import com.ensat.demo.repositories.StockRepository;

@Service
public class StockService implements ICrudService<Stock> {

	private StockRepository stockRepository;
	@Autowired
	public void setStockRepository(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	@Override
	public void save(Stock entity) {
		stockRepository.save(entity);
	}

	@Override
	public void delete(Stock entity) {
		stockRepository.delete(entity);
	}

	@Override
	public Optional<Stock> find(int id) {
		return stockRepository.findById(id);
	}

	@Override
	public Iterable<Stock> all() {
		return stockRepository.findAll();
	}

}
