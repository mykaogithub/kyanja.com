package com.kyanja.service;

import java.util.List;

import com.kyanja.model.Categorie;
import com.kyanja.model.CategorieDTO;
import com.kyanja.model.Produit;

public interface IUserCatalogue {
	
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCat);
	public List<Produit> listproduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idP);
	public List<Produit> produitsParCategorie(Long idCat);
	public List<CategorieDTO> listDToCategories();

}
