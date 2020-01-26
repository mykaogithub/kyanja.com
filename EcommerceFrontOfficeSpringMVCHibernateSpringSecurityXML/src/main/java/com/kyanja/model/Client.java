package com.kyanja.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1726010966627437441L;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long idClient;
private String nomClient;
private String adresse;
private String email;
private String tel;
@OneToMany(mappedBy="client")
private List<Commande> commandes;
// Getters et Setters
// Cosntructeur sans paramètre
// Cosntructeur avec paramètres
public Long getIdClient() {
	return idClient;
}
public void setIdClient(Long idClient) {
	this.idClient = idClient;
}
public String getNomClient() {
	return nomClient;
}
public void setNomClient(String nomClient) {
	this.nomClient = nomClient;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public List<Commande> getCommandes() {
	return commandes;
}
public void setCommandes(List<Commande> commandes) {
	this.commandes = commandes;
}
public Client() {
	super();
}
public Client(String nomClient, String adresse, String email, String tel, List<Commande> commandes) {
	super();
	this.nomClient = nomClient;
	this.adresse = adresse;
	this.email = email;
	this.tel = tel;
	this.commandes = commandes;
}
@Override
public String toString() {
	return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", adresse=" + adresse + ", email=" + email
			+ ", tel=" + tel + ", commandes=" + commandes + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
	result = prime * result + ((commandes == null) ? 0 : commandes.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((idClient == null) ? 0 : idClient.hashCode());
	result = prime * result + ((nomClient == null) ? 0 : nomClient.hashCode());
	result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
	Client other = (Client) obj;
	if (adresse == null) {
		if (other.adresse != null)
			return false;
	} else if (!adresse.equals(other.adresse))
		return false;
	if (commandes == null) {
		if (other.commandes != null)
			return false;
	} else if (!commandes.equals(other.commandes))
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (idClient == null) {
		if (other.idClient != null)
			return false;
	} else if (!idClient.equals(other.idClient))
		return false;
	if (nomClient == null) {
		if (other.nomClient != null)
			return false;
	} else if (!nomClient.equals(other.nomClient))
		return false;
	if (tel == null) {
		if (other.tel != null)
			return false;
	} else if (!tel.equals(other.tel))
		return false;
	return true;
}


}