package com.kyanja.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kyanja.model.Categorie;
import com.kyanja.model.Produit;

@Repository
public class CatalogueDaoImpl implements ICatalogueDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CatalogueDaoImpl.class);

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Long ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();

		session.save(c);
		return c.getIdCategorie();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		return session.createQuery("from Categorie").list();

		

	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		return	(Categorie) session.get(Categorie.class, idCat);
		
	}

	@Override
	public void supprimerCategrorie(Long idcat) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Categorie c=getCategorie(idcat);
		session.delete(c);
	}

	@Override
	public void modifierCategorie(Categorie c) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.merge(c);
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unused")
		Categorie c =getCategorie(idCat);
		session.save(p);
		return p.getIdProduit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> listproduits() {
		// TODO Auto-generated method stub
//		Session session = sessionFactory.getCurrentSession();
//		Query req= (Query) session.createQuery("select p from Produit p");
//		return req.getResultList();
		Session session = this.sessionFactory.getCurrentSession();
		List<Produit> produitsList = session.createQuery("from Produit").list();
		for(Produit p : produitsList){
			logger.info("Produit List::"+p);
		}
		return produitsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> produitsParMotCle(String mc) {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.getCurrentSession();
		Query req =   session.createQuery("select p from Produit p where p.designation like"
				+ ":x or p.description like :x");
				req.setParameter("x", "%"+mc+"%");
				
				req.setParameter("x", mc);
				return req.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		
		Session session = sessionFactory.getCurrentSession();
		Query req =   session.createQuery("from Produit p where p.categorie.idCategorie=:x");
				req.setParameter("x", idCat);
				return req.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> produitsSelectionnes() {
		// TODO Auto-generated method stub
		
//		String hql = "from Produit p where p.selectionne= :true";
//		
//		 Query query  = sessionFactory.getCurrentSession().createQuery(hql);
//		 
//		 query.setParameter("selectionne", true);
//			return query.list();
		
		Session session = this.sessionFactory.getCurrentSession();		
		Criteria cr = session.createCriteria(Produit.class);
		cr.add(Restrictions.eq("selectionne",true));
		@SuppressWarnings("rawtypes")
		List results = cr.list();
		
		return results;
		
	}

	@Override
	public Produit getProduit(Long idP) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return (Produit) session.get(Produit.class,idP);
	}

	@SuppressWarnings({ })
	@Override
	public void supprimerProduit(Long idP) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Produit p= getProduit(idP);
		session.delete(p);
		
	}

	@Override
	public void modifierProduit(Produit p) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.merge(p);
	}

}
