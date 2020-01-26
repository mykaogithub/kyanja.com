package com.kyanja.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Produit implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 5977365828450504492L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
private Long idProduit;
@NotEmpty
private String designation; 
private String description;
private double prix;
private String photo;
private int quantite;
private boolean selectionne;

@ManyToOne
@JoinColumn(name="ID_CAT")
private Categorie categorie;
// Getters et Setters
// Cosntructeur sans param�tre
// Cosntructeur avec param�tres
public Long getIdProduit() {
	return idProduit;
}
public void setIdProduit(Long idProduit) {
	this.idProduit = idProduit;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public boolean isSelectionne() {
	return selectionne;
}
public void setSelectionne(boolean selectionne) {
	this.selectionne = selectionne;
}


public Categorie getCategorie() {
	return categorie;
}

public void setCategorie(Categorie categorie) {
	this.categorie = categorie;
}
public Produit() {
	super();
}
public Produit(String designation, String description, double prix, String photo, int quantite, boolean selectionne,
		Categorie categorie) {
	super();
	this.designation = designation;
	this.description = description;
	this.prix = prix;
	this.photo = photo;
	this.quantite = quantite;
	this.selectionne = selectionne;
	this.categorie = categorie;
}
@Override
public String toString() {
	return "Produit [idProduit=" + idProduit + ", designation=" + designation + ", description=" + description
			+ ", prix=" + prix + ", photo=" + photo + ", quantite=" + quantite + ", selectionne=" + selectionne
			+ ", categorie=" + categorie + "]";
}

//@Override
//public boolean equals(Object o) {
//    if (this == o) return true;
//    if (!(o instanceof Produit)) return false;
//    return idProduit != null && idProduit.equals(((Produit) o).idProduit);
//}
//
//@Override
//public int hashCode() {
//    return 31;
//}
}