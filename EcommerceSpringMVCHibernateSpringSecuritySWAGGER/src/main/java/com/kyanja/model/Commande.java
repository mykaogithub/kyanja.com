package com.kyanja.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -3337133477621198389L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCommande;
	private Date dateCommande;
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;
	@OneToMany
	@JoinColumn(name = "idCommande")
	private Collection<ArticlePanier> ligneCommandes;

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<ArticlePanier> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(Collection<ArticlePanier> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}



	public Commande() {
		super();
	}

	public Commande(Date dateCommande, Client client, Collection<ArticlePanier> ligneCommandes) {
	super();
	this.dateCommande = dateCommande;
	this.client = client;
	this.ligneCommandes = ligneCommandes;
}

	public Commande(Long idCommande, Date dateCommande, Client client, Collection<ArticlePanier> ligneCommandes) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		this.client = client;
		this.ligneCommandes = ligneCommandes;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", dateCommande=" + dateCommande + ", client=" + client
				+ ", ligneCommandes=" + ligneCommandes + "]";
	}
	
}
