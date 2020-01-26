package com.kyanja.service;

import com.kyanja.model.Produit;

public interface IAdminProduitService extends InternauteBoutiqueService{
	
	public Long ajouterProduit(Produit p, Long idCat);
	public void supprimerProduit(Long idP);
	public void modifierProduit(Produit p);

}
