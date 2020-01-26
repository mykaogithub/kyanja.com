package com.kyanja.service;

import com.kyanja.model.Produit;

public interface IProduitsManager  extends IUserCatalogue {
	
	public Long ajouterProduit(Produit p, Long idCat);
	public void supprimerProduit(Long idP);
	public void modifierProduit(Produit p);
	

}
