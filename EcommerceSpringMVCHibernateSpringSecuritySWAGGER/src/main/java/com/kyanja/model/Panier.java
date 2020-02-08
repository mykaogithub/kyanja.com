package com.kyanja.model;

import java.io.Serializable;
import java.util.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Panier implements Serializable {
	/**
		 * 
		 */
//	private static final long serialVersionUID = 4329585226337717550L;
//	
//	private Map<Long, LigneCommande> items=new HashMap<Long, LigneCommande>();
//	
//	public void ajouterArticle(Produit p, int quantite){
//		
//	LigneCommande lc=items.get(p.getIdProduit());
//	if(lc==null){
//	LigneCommande art=new LigneCommande();
//	art.setProduit(p);
//	art.setQuantite(quantite);
//	art.setPrix(p.getPrix());
//	items.put(p.getIdProduit(), art);
//	}
//	else{
//	lc.setQuantite(lc.getQuantite()+quantite);
//	}
//	}
//	public List<LigneCommande> getItems(){
//		return (List<LigneCommande>) items.values();
//		}
//		public int getSize(){
//		return items.size();
//		}
//		public double getTotal(){
//		double total=0;
//		for(LigneCommande lc:items.values()){
//		total+=lc.getPrix()*lc.getQuantite();
//		}
//		return total;
//		}
//		public void deleteItem(Long idproduit){
//		items.remove(idproduit);
//		}
	private Map<Long, ArticlePanier> articles = new HashMap<Long, ArticlePanier>();

	public void ajouterArticle(Produit p, int quantite) {
		ArticlePanier art = articles.get(p.getIdProduit());
		if (art != null)
			art.setQuantite(art.getQuantite() + quantite);
		else
			articles.put(p.getIdProduit(), new ArticlePanier(p, quantite));
	}

	public Collection<ArticlePanier> getArticles() {
		return articles.values();
	}

	public double getTotal() {
		double total = 0;
		Collection<ArticlePanier> items = getArticles();
		for (ArticlePanier art : items) {
			total += art.getQuantite() * art.getProduit().getPrix();
		}
		return total;
	}

	public void deleteItem(Long idProduit) {
		articles.remove(idProduit);
	}

	public int getSize() {
		int nb = 0;
		Collection<ArticlePanier> items = getArticles();
		for (ArticlePanier art : items) {
			nb += art.getQuantite();
		}
		return nb;
	}
}