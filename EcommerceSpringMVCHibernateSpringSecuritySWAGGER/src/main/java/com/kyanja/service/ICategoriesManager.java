package com.kyanja.service;

import com.kyanja.model.Categorie;

public interface ICategoriesManager extends IUserCatalogue{
	
	
	public Long ajouterCategorie(Categorie c);
	public void supprimerCategrorie(Long idcat);
	public void modifierCategorie(Categorie c);

}
