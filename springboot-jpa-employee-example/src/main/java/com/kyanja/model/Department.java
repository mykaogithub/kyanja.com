package com.kyanja.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "Department")
@Proxy(lazy=false)


public class Department implements Serializable{


    /**
	 * 
	 */
	private static final long serialVersionUID = -6680966783414553539L;


	@Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	
	private String name;
	
 
	  @OneToMany(mappedBy = "department",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	 
     private Set <Employee> employees = new HashSet<>();

	  @JsonIgnore  
	public Set<Employee> getEmployees() {
		return employees;
	}

	  @JsonIgnore
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department() {
		
	}

	public Department(String name) {
		super();
		this.name = name;
	}



	

	public Department(String name, Set<Employee> employees) {
		super();
		this.name = name;
		this.employees = employees;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employees=" + employees + "]";
	}


	



	
	
	

}
