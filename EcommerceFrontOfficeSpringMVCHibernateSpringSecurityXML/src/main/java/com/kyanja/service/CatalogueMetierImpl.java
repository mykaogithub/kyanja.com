package com.kyanja.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyanja.dao.ICatalogueDao;
import com.kyanja.model.Categorie;
import com.kyanja.model.CategorieDTO;
import com.kyanja.model.Produit;


@Service
@Transactional
public class CatalogueMetierImpl implements  IProduitsManager,ICategoriesManager {
	
	
	@Autowired
	private ICatalogueDao dao;

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.getCategorie(idCat);
	}

	@Override
	public List<Produit> listproduits() {
		// TODO Auto-generated method stub
		return dao.listproduits();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return dao.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		// TODO Auto-generated method stub
		return dao.produitsSelectionnes();
	}

	@Override
	public Produit getProduit(Long idP) {
		// TODO Auto-generated method stub
		return dao.getProduit(idP);
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.produitsParCategorie(idCat);
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategrorie(Long idcat) {
		
		dao.supprimerCategrorie(idcat);
		
		
		
	}

	@Override
	public void modifierCategorie(Categorie c) {
		// TODO Auto-generated method stub
		dao.modifierCategorie(c);
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		// TODO Auto-generated method stub
		return dao.ajouterProduit(p, idCat);
	}

	@Override
	public void supprimerProduit(Long idP) {
		// TODO Auto-generated method stub
		dao.supprimerProduit(idP);
	}

	@Override
	public void modifierProduit(Produit p) {
		// TODO Auto-generated method stub
		dao.modifierProduit(p);
	}

	public List<CategorieDTO> listDToCategories() {
		 // Here you need to transform entities to DTO. If you use entities this is not required.
	    List<Categorie> list = dao.listCategories();
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
