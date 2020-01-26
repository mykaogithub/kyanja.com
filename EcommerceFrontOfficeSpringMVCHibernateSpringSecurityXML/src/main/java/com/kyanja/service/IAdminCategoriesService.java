package com.kyanja.service;

import com.kyanja.model.Categorie;
import com.kyanja.model.Role;
import com.kyanja.model.User;

public interface IAdminCategoriesService extends IAdminProduitService {
	
	public Long ajouterCategorie(Categorie c);
	public void supprimerCategrorie(Long idcat);
	public void modifierCategorie(Categorie c);
	public void ajouterUser(User u);
	public void attribuerRole(Role r, Long idRole, User user);

}
