package com.kyanja.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.kyanja.dao.IBoutiqueDao;
import com.kyanja.model.Categorie;
import com.kyanja.model.CategorieDTO;
import com.kyanja.model.Client;
import com.kyanja.model.Commande;
import com.kyanja.model.Panier;
import com.kyanja.model.Produit;
import com.kyanja.model.Role;
import com.kyanja.model.User;

@Service
@Transactional

public class BoutiqueServiceImpl implements IAdminCategoriesService {

	
	@Autowired
	
	IBoutiqueDao boutiqueDao;
	
	

	public Long ajouterProduit(Produit p, Long idCat) {

		
	    return boutiqueDao.ajouterProduit(p, idCat);

	}


	public void supprimerProduit(Long idP) {
		
		boutiqueDao.supprimerProduit(idP);

	}


	public void modifierProduit(Produit p) {
		// TODO Auto-generated method stub
		
		boutiqueDao.modifierProduit(p);

	}


	public List<Categorie> listCategories() {
		
	
		return boutiqueDao.listCategories();
	}

	
	public Categorie getCategorie(Long idCat) {
	
		
		
		return boutiqueDao.getCategorie(idCat);
	}


	public List<Produit> listproduits() {

		return boutiqueDao.listproduits();
	}


	public List<Produit> produitsParMotCle(String mc) {
		
		return boutiqueDao.produitsParMotCle(mc);
	}


	public List<Produit> produitsParCategorie(Long idCat) {
	
		return boutiqueDao.produitsParCategorie(idCat);
	}

	public List<Produit> produitsSelectionnes() {
	
		return boutiqueDao.produitsSelectionnes();
	}


	
	public Produit getProduit(Long idP) {

		return boutiqueDao.getProduit(idP);
	}


	public Commande enregistrerCommande(Panier p, Client c) {

		return boutiqueDao.enregistrerCommande(p, c);
	}


	public Long ajouterCategorie(Categorie c) {

		return boutiqueDao.ajouterCategorie(c);
	}


	public void supprimerCategrorie(Long idcat) {

		boutiqueDao.supprimerCategrorie(idcat);

	}


	public void modifierCategorie(Categorie c) {
	
		
		boutiqueDao.modifierCategorie(c);

	}


	public void ajouterUser(User u) {
		
		boutiqueDao.ajouterUser(u);
	}


	public void attribuerRole(Role r, Long idRole, User user) {

		boutiqueDao.attribuerRole(r, idRole, user);
		
	
	}


	public List<CategorieDTO> listDToCategories() {
		 // Here you need to transform entities to DTO. If you use entities this is not required.
	    List<Categorie> list = boutiqueDao.listCategories();
	    List<CategorieDTO> dtoList = new ArrayList<CategorieDTO>();
	    for(Categorie categorie:list){
	    	CategorieDTO catDTO = new CategorieDTO();
	    	catDTO.setNomCategorie(categorie.getNomCategorie());
	    	catDTO.setIdCategorie(categorie.getIdCategorie());
	    	catDTO.setPhoto(categorie.getPhoto());
	     
	    
	      dtoList.add(catDTO);
	}
		return dtoList;
	}
}
