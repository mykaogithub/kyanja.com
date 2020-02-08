package com.kyanja.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommande implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -5724306113371597883L;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
@ManyToOne
@JoinColumn(name="idproduit")
private Produit produit;
private int quantite;
private double prix;
// Getters et Setters
// Cosntructeur sans paramètre
// Cosntructeur avec paramètres
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
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
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public LigneCommande() {
	super();
}
public LigneCommande(Produit produit, int quantite, double prix) {
	super();
	this.produit = produit;
	this.quantite = quantite;
	this.prix = prix;
}
@Override
public String toString() {
	return "LigneCommande [id=" + id + ", produit=" + produit + ", quantite=" + quantite + ", prix=" + prix + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	long temp;
	temp = Double.doubleToLongBits(prix);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((produit == null) ? 0 : produit.hashCode());
	result = prime * result + quantite;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	LigneCommande other = (LigneCommande) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
		return false;
	if (produit == null) {
		if (other.produit != null)
			return false;
	} else if (!produit.equals(other.produit))
		return false;
	if (quantite != other.quantite)
		return false;
	return true;
}



}
