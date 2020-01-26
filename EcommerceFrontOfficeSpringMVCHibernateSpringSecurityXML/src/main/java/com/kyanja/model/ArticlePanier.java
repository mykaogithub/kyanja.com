package com.kyanja.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ArticlePanier {
	@Id
   private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Produit produit;
	private int quantite;

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public ArticlePanier(Produit produit, int quantite) {
		super();
		this.produit = produit;
		this.quantite = quantite;
	}

	public ArticlePanier() {
		super();
	}

	@Override
	public String toString() {
		return "ArticlePanier [produit=" + produit + ", quantite=" + quantite + "]";
	}

// Getters et Setters
// Constructeurs
}
