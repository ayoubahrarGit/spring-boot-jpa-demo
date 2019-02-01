package com.ensat.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.demo.beans.StockViewBean;
import com.ensat.demo.entities.Entrepot;
import com.ensat.demo.entities.Produit;
import com.ensat.demo.entities.Stock;
import com.ensat.demo.repositories.EntrepotRepository;
import com.ensat.demo.repositories.ProduitRepository;
import com.ensat.demo.repositories.StockRepository;

@Service
public class StockService implements ICrudService<Stock> {

	private StockRepository stockRepository;
	
	@Autowired
	public void setStockRepository(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	private ProduitRepository produitRepository;
	
	@Autowired
	public void setProduitRepository(ProduitRepository produitRepository) {
		this.produitRepository = produitRepository;
	}
	
	private EntrepotRepository entrepotRepository;
	
	@Autowired
	public void setEntrepotRepository(EntrepotRepository entrepotRepository) {
		this.entrepotRepository = entrepotRepository;
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
	
	public Stock find(String entrepot, String produit) {
		Entrepot e = entrepotRepository.findByName(entrepot).get();
		Produit p = produitRepository.findByName(produit).get();
		Stock s = stockRepository.findByEntrepotAndProduit(e,p);
		return s;
	}

	@Override
	public Iterable<Stock> all() {
		return stockRepository.findAll();
	}
	
	public boolean exist(Entrepot e,Produit p){
		return stockRepository.existsByEntrepotAndProduit(e, p);
			
	}
	
	public List<StockViewBean> toViewBean(){
		List<StockViewBean> lsv=new ArrayList<>();
		List<Stock> ls = (List<Stock>) this.all();
		for(Stock s : ls ){
			lsv.add(this.toView(s));
		}
		return lsv;
	}
	public Stock toEntity(StockViewBean sv){
		Entrepot e = entrepotRepository.findByName(sv.getEntrepot()).get() ;
		Produit p = produitRepository.findByName(sv.getProduit()).get();
		if(exist(e, p)){
			Stock s = stockRepository.findByEntrepotAndProduit(e,p);
			s.setQuantite(sv.getQuantite());
			return s;
		}else{
			Stock s = new Stock();
			s.setEntrepot(e);
			s.setProduit(p);
			s.setQuantite(sv.getQuantite());
			return s;
		}			
	}
	
	public StockViewBean toView(Stock s){
		StockViewBean sv = new StockViewBean();
		sv.setIdstock(s.getIdstock());
		sv.setEntrepot(s.getEntrepot().getName());
		sv.setProduit(s.getProduit().getName());
		sv.setQuantite(s.getQuantite());
		return sv;
	}
	public int count(){
		return (int) stockRepository.count();
	}
	public int sum(){
		if(stockRepository.getSum()==null)
			return 0;
		else
			return stockRepository.getSum().intValue();
	}
}
