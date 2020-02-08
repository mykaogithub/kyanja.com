package com.kyanja.service;

import java.util.List;

import com.kyanja.model.Categorie;
import com.kyanja.model.CategorieDTO;
import com.kyanja.model.Client;
import com.kyanja.model.Commande;
import com.kyanja.model.Panier;
import com.kyanja.model.Produit;

public interface InternauteBoutiqueService {
	
	public List<Categorie> listCategories();
	public List<CategorieDTO> listDToCategories();
	public Categorie getCategorie(Long idCat);
	public List<Produit> listproduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsParCategorie(Long idCat);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idP);
	public Commande enregistrerCommande(Panier p,Client c);

}

