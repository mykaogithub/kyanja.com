package com.kyanja;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


import com.kyanja.model.Department;
import com.kyanja.model.Employee;

import com.kyanja.repository.DepartmentDao;
import com.kyanja.repository.EmployeeDao;



@SpringBootApplication
//@EnableJpaAuditing //  Enabling JPA Auditing

public class SpringbootJpaEmployeeExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaEmployeeExampleApplication.class, args);
	}

	@Bean
    public CommandLineRunner mappingDemo(
    	
    		
    		EmployeeDao empRepository, DepartmentDao deptRepository
    	
                                         ) {
        return args -> {
        	
        	
        	
        	// create a new department
        	
        
      
        	// create a new department
      Department dept = new Department();
        	
      dept.setName("Research and Developpement");
        	
       deptRepository.save(dept);
        	
      
          
          Employee emp1 = new Employee();
          emp1.setName("nadir");
          emp1.setDesignation("human ressources manager");
          emp1.setSalary(666333);
          emp1.setDepartment(dept);
         
          Employee emp2 = new Employee();
          emp2.setName("omar");
          emp2.setDesignation("hr developper");
          emp2.setSalary(111133);
          emp2.setDepartment(dept);
          


        empRepository.save(emp1);
         empRepository.save(emp2);
            // save the new department
         

        	
        
     
        };
    }
	
	
}


