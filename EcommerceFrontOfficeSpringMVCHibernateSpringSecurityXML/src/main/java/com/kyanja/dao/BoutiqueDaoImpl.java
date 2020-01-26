package com.kyanja.dao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kyanja.model.ArticlePanier;
import com.kyanja.model.Categorie;
import com.kyanja.model.CategorieDTO;
import com.kyanja.model.Client;
import com.kyanja.model.Commande;
import com.kyanja.model.Employee;
import com.kyanja.model.LigneCommande;
import com.kyanja.model.Panier;
import com.kyanja.model.Produit;
import com.kyanja.model.Role;
import com.kyanja.model.User;


@Repository

public class BoutiqueDaoImpl implements IBoutiqueDao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	

	public Long ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		
		
		return (Long) sessionFactory.getCurrentSession().save(c);
	}

	@SuppressWarnings("unchecked")
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Categorie").list();
	}


	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
//		Categorie categorie = (Categorie) sessionFactory.getCurrentSession().get(Categorie.class, idCat);
//		
//		
//		return categorie;
		
		
	       Criteria crit = sessionFactory.getCurrentSession().createCriteria(Categorie.class);
	        crit.add(Restrictions.eq("id", idCat));
	        return (Categorie) crit.uniqueResult();
	}


	public void supprimerCategrorie(Long idcat) {
		// TODO Auto-generated method stub
		
		Categorie categorie = (Categorie) sessionFactory.getCurrentSession().load(Categorie.class, idcat);
		
		if (null != categorie) {
		
			sessionFactory.getCurrentSession().delete(categorie);
	}

	}
	public void modifierCategorie(Categorie c) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().update(c);

	}


	public Long ajouterProduit(Produit p, Long idCat) {
		// TODO Auto-generated method stub
		
  Categorie categorie = (Categorie) sessionFactory.getCurrentSession().get(Categorie.class, idCat);
		p.setCategorie(categorie);
		return (Long) sessionFactory.getCurrentSession().save(p);
	}

	
	@SuppressWarnings("unchecked")
	public List<Produit> listproduits() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Produit").list();
	}


	@SuppressWarnings("unchecked")
	public List<Produit> produitsParMotCle(String mc) {
		// TODO Auto-generated method stub
		Query req= (Query) sessionFactory.getCurrentSession()
				.createQuery("select p from Produit p where p.designation like:x or p.description like:x");
				req.setParameter("x", "%"+mc+"%");
				return req.getResultList();
	}


	public List<Produit> produitsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		//Join example for selecting few columns
//			Criteria	criteria = sessionFactory.getCurrentSession().createCriteria(Produit.class, "produit");
//				criteria.setFetchMode("produit.categorie", FetchMode.JOIN);
//				criteria.createAlias("produit.categorie", "categorie"); // inner join by default
//
//		ProjectionList columns = Projections.projectionList()
//								.add(Projections.property("nomCategorie"))
//								.add(Projections.property("categorie.nomCategorie"));
//				criteria.setProjection(columns);
//
//				List<Produit> list = criteria.list();
//			
//				for (Produit produit : list) {
//					
//					System.out.println(list.toString());
//					
//				}
//				return list;
          
		Query req=(Query) sessionFactory.getCurrentSession()
				.createQuery("select p from Produit p where p.categorie.idCategorie=:x");
				req.setParameter("x", idCat);
				return req.getResultList();
	}
	
	public List<Produit> produitsSelectionnes() {
		// TODO Auto-generated method stub
		Query req=(Query) sessionFactory.getCurrentSession()
				.createQuery("select p from Produit p where p.selectionne=true");
				return req.getResultList();
	}

	
	public Produit getProduit(Long idP) {
		// TODO Auto-generated method stub
//		return (Produit) sessionFactory.getCurrentSession().get(Produit.class, idP);
			
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Produit.class);
        crit.add(Restrictions.eq("id", idP));
        return (Produit) crit.uniqueResult();
	}


	public void supprimerProduit(Long idP) {
		// TODO Auto-generated method stub
	Produit produit	= (Produit) sessionFactory.getCurrentSession().load(Produit.class, idP);
	
	if (null!= produit) {
		
		sessionFactory.getCurrentSession().delete(produit);
		
	}
	
	}


	public void modifierProduit(Produit p) {
		// TODO Auto-generated method stub

		sessionFactory.getCurrentSession().update(p);
	}

	
	public void ajouterUser(User u) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(u);
	}


	public void attribuerRole(Role r, Long idRole, User user) {
		// TODO Auto-generated method stub.
		
	 r = (Role) sessionFactory.getCurrentSession().get(Role.class, idRole);
	 
	 r.setUser(user);
	 
		sessionFactory.getCurrentSession().persist(r);
	}

	
	public Commande enregistrerCommande(Panier panier, Client c) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(c);
		Commande cmd=new Commande();
		cmd.setClient(c);
		Collection<ArticlePanier> ligneCommandes = panier.getArticles();
		cmd.setLigneCommandes(ligneCommandes);

		sessionFactory.getCurrentSession().persist(cmd);
		return cmd;
	}



}
