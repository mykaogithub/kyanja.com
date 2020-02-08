package com.kyanja.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Categorie implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 8739431087212428537L;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@GeneratedValue
private Long idCategorie;
@NotEmpty
@Size(min=4,max=20)
private String nomCategorie; 
private String description;
private String nomPhoto;
@Lob
private byte[] photo;
@OneToMany(mappedBy="categorie")
private Collection<Produit> produits=new ArrayList<Produit>();
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//private Set<Produit> produits= new HashSet<Produit>();
// Getters et Setters
// Constructeurs sans paramètre et avec paramètres
public Long getIdCategorie() {
	return idCategorie;
}
public void setIdCategorie(Long idCategorie) {
	this.idCategorie = idCategorie;
}
public String getNomCategorie() {
	return nomCategorie;
}
public void setNomCategorie(String nomCategorie) {
	this.nomCategorie = nomCategorie;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getNomPhoto() {
	return nomPhoto;
}
public void setNomPhoto(String nomPhoto) {
	this.nomPhoto = nomPhoto;
}
public byte[] getPhoto() {
	return photo;
}
public void setPhoto(byte[] photo) {
	this.photo = photo;
}


public Collection<Produit> getProduits() {
	return produits;
}
public void setProduits(Collection<Produit> produits) {
	this.produits = produits;
}
//public List<Produit> getProduits() {
//	return produits;
//}
//
//public void setProduits(List<Produit> produits) {
//	this.produits = produits;
//}
public Categorie() {
	super();
}
//public Categorie(String nomCategorie, String description, String nomPhoto, byte[] photo, List<Produit> produits) {
//	super();
//	this.nomCategorie = nomCategorie;
//	this.description = description;
//	this.nomPhoto = nomPhoto;
//	this.photo = photo;
//	this.produits = produits;
//}



public Categorie(String nomCategorie, String description, String nomPhoto, byte[] photo) {
	super();
	this.nomCategorie = nomCategorie;
	this.description = description;
	this.nomPhoto = nomPhoto;
	this.photo = photo;
}
@Override
public String toString() {
	return "Categorie [idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", description=" + description
			+ ", nomPhoto=" + nomPhoto + ", photo=" + Arrays.toString(photo) + ", produits=" + produits + "]";
}
public Categorie(String nomCategorie, String description, String nomPhoto, byte[] photo, Collection<Produit> produits) {
	super();
	this.nomCategorie = nomCategorie;
	this.description = description;
	this.nomPhoto = nomPhoto;
	this.photo = photo;
	this.produits = produits;
}
public Categorie(Long idCategorie, String nomCategorie, String description, String nomPhoto, byte[] photo,
		Collection<Produit> produits) {
	super();
	this.idCategorie = idCategorie;
	this.nomCategorie = nomCategorie;
	this.description = description;
	this.nomPhoto = nomPhoto;
	this.photo = photo;
	this.produits = produits;
}




//@Override
//public boolean equals(Object o) {
//    if (this == o) return true;
//    if (!(o instanceof Categorie)) return false;
//    return idCategorie != null && idCategorie.equals(((Categorie) o).getIdCategorie());
//}
//
//@Override
//public int hashCode() {
//    return 31;
//}

}