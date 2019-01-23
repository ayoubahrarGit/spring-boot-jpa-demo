package com.ensat.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the entrepot database table.
 * 
 */
@Entity
@NamedQuery(name="Entrepot.findAll", query="SELECT e FROM Entrepot e")
public class Entrepot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int identrepot;

	private String name;

	private String ville;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="entrepot")
	private List<Stock> stocks;

	public Entrepot() {
	}

	public int getIdentrepot() {
		return this.identrepot;
	}

	public void setIdentrepot(int identrepot) {
		this.identrepot = identrepot;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setEntrepot(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setEntrepot(null);

		return stock;
	}

}