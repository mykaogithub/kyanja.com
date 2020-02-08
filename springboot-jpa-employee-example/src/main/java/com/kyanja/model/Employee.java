package com.kyanja.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("deprecation")
@Entity

public class Employee implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = -1907460169010580078L;


	

	@Column(name = "empId", nullable = false, length = 10)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long empId;
	
	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

//	 @JsonIgnore
	public Department getDepartment() {
		return department;
	}

//	 @JsonIgnore
	public void setDepartment(Department department) {
		this.department = department;
	}

	@NotNull
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
	
	@NotNull
	@Size(min = 2, message = "designation should have atleast 2 characters")
	private String designation;
	

	private double salary;
	



	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "departmentId", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
        
	    private Department department;

	public Employee() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(@NotNull @Size(min = 2, message = "Name should have atleast 2 characters") String name,
			@NotNull @Size(min = 2, message = "designation should have atleast 2 characters") String designation,
			@NotBlank double salary) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", designation=" + designation + ", salary=" + salary
				+ ", department=" + department + "]";
	}

	public Employee(@NotNull @Size(min = 2, message = "Name should have atleast 2 characters") String name,
			@NotNull @Size(min = 2, message = "designation should have atleast 2 characters") String designation,
			double salary, Department department) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.department = department;
	}


}