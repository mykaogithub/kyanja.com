package com.kyanja.model;

import java.sql.Timestamp;

public class CategorieDTO {
	
	private Long idCategorie;
	
	private String nomCategorie;
	
	private byte[] photo;
	
//	private Timestamp  createdOn;

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

//	public Timestamp getCreatedOn() {
//		return createdOn;
//	}
//
//	public void setCreatedOn(Timestamp createdOn) {
//		this.createdOn = createdOn;
//	} 
	
	

}
