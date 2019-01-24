package com.ensat.demo.beans;

import com.ensat.demo.entities.Produit;

public class ProduitViewBean {
	
	private int idproduit;
	private String description;
	private String label;
	private String name;
	private String categorie;

	public int getIdproduit() {
		return idproduit;
	}

	public void setIdproduit(int idproduit) {
		this.idproduit = idproduit;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String name_categorie) {
		this.categorie = name_categorie;
	}

	public Produit toProduit() {
		Produit p = new Produit();
		p.setIdproduit(idproduit);
		p.setDescription(description);
		p.setLabel(label);
		p.setName(name);
		return p;
	}
	
	public void fromProduit(Produit p) {
		idproduit = p.getIdproduit();
		description = p.getDescription();
		label = p.getLabel();
		name = p.getName();
		categorie = p.getCategorie().getName();
		
	}
}
