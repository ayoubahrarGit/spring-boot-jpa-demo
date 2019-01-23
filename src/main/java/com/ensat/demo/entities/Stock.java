package com.ensat.demo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stock database table.
 * 
 */
@Entity
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int quantite;

	//bi-directional many-to-one association to Entrepot
	@ManyToOne
	@JoinColumn(name="identrepot")
	private Entrepot entrepot;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="idproduit")
	private Produit produit;

	public Stock() {
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Entrepot getEntrepot() {
		return this.entrepot;
	}

	public void setEntrepot(Entrepot entrepot) {
		this.entrepot = entrepot;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}