package com.kyanja.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kyanja.model.Panier;
import com.kyanja.model.Produit;
import com.kyanja.service.IAdminProduitService;
import com.kyanja.service.IUserCatalogue;

@Controller
@SessionAttributes("panier")
public class EBoutiqueController {

	@Autowired
	private IUserCatalogue metier;
	
	@Autowired
	private IAdminProduitService metierManager;

	@RequestMapping("/index")
	public String index(Model model) {
		if (model.asMap().get("panier") == null) {
			model.addAttribute("panier", new Panier());
		}
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("produits", metier.produitsSelectionnes());
		return "index";
	}

	@RequestMapping("/produitsParCat")
	public String produitsParCat(@RequestParam Long idCat, Model model) {
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("produits", metier.produitsParCategorie(idCat));
		return "index";
	}

	@RequestMapping("/chercherProduits")
	public String chercherProduits(@RequestParam String mc, Model model) {
		model.addAttribute("mc", mc);
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("produits", metier.produitsParMotCle(mc));
		return "index";
	}





	@RequestMapping(value="photoProd",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photCat(Long idProd) throws IOException{
	Produit p=metier.getProduit(idProd);
	File f=new
	File(System.getProperty("java.io.tmpdir")+"/PROD_"+idProd+"_"+p.getPhoto(
	));
	return IOUtils.toByteArray(new FileInputStream(f));
	}
	
	
	@RequestMapping("/ajouterAuPanier")
	public String chercherProduits(@RequestParam Long idProduit, @RequestParam int quantite, Model model) {
		Panier panier = null;
		if (model.asMap().get("panier") == null) {
			panier = new Panier();
			model.addAttribute("panier", panier);
		} else
			panier = (Panier) model.asMap().get("panier");
		panier.ajouterArticle(metier.getProduit(idProduit), quantite);
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("produits", metier.produitsSelectionnes());
		return "index";
	}

}
