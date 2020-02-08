package com.kyanja.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long idUser;
  
	
	private String userName;
	
	private String password;
	
	private boolean activated;
	
	
	@OneToMany(mappedBy="user")
	private List<Role> roles=new ArrayList<Role>();

	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}



	public User() {
		super();
	}



	public User(String userName, String password, boolean activated) {
		super();
		this.userName = userName;
		this.password = password;
		this.activated = activated;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", userName=" + userName + ", password=" + password + ", activated="
				+ activated + ", users=" + roles + "]";
	}

	



	
	
	
	

}
