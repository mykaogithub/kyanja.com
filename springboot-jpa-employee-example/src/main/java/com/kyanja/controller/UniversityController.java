package com.kyanja.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kyanja.exception.ResourceNotFoundException;

import com.kyanja.model.Department;
import com.kyanja.model.Employee;

import com.kyanja.service.DepartmentService;
import com.kyanja.service.EmployeeService;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class UniversityController {



 



  




 



    //  Employee management for university
    
    @Autowired
	
  	DepartmentService departmentService;
      
      
      @Autowired
  	
   	  EmployeeService employeeService;
      
      @RequestMapping(value = "/departments-list", method = RequestMethod.GET)
      public List<Department> getDepartments() {
          return departmentService.getDepartments();
      }
      
      @RequestMapping(value = "/save-department", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
      public Department createDepartment(@RequestBody Department department) {
          return departmentService.createDepartment(department);
      }
      

      @RequestMapping(value = "/department/{departmentId}", method = RequestMethod.GET)
      public Optional<Department> getDepartmentById(@PathVariable(value = "departmentId") Long departmentId) throws ResourceNotFoundException {
          return departmentService.getDepartmentById(departmentId);
      }
      
      @RequestMapping(value = "/update-department/{departmentId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
      public Department updateDepartment(@PathVariable(value = "departmentId") Long departmentId, 
    		
    		  @RequestBody Department department) throws ResourceNotFoundException {
          return departmentService.updateDepartmentById(departmentId, department);
      }
      
      @RequestMapping(value = "/delete-department/{departmentId}", method = RequestMethod.DELETE)
      public ResponseEntity<Object> deleteDepartmentById(@PathVariable(value = "departmentId") long departmentId) throws ResourceNotFoundException {
          return departmentService.deleteDepartmentById(departmentId);
      }
      
      @RequestMapping(value = "/employees-list", method = RequestMethod.GET)
      public List<Employee> getEmployees() {
          return employeeService.getAllEmployees();
      }
      
   @RequestMapping(value = "/save-employee/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)

      public Employee createEmployee(@PathVariable(value = "id") Long departmentId, @RequestBody Employee employee) throws ResourceNotFoundException {
          return employeeService.createEmployee(departmentId, employee);
      }
      
      @RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.GET)
      public Optional<Employee> getEmployeeById(@PathVariable(value = "employeeId") Long employeeId) throws ResourceNotFoundException {
          return employeeService.getEmployeeById(employeeId);
      }

      
      @PutMapping("/update-employee/{employeeId}/employees/{departmentId}")
      public Employee updateEmployee(@PathVariable (value = "departmentId") Long departmentId,
              @PathVariable (value = "employeeId") Long employeeId,
              @Valid  @RequestBody Employee employee) throws ResourceNotFoundException {
          
    	  return employeeService.updateEmployeeById(employeeId, departmentId, employee);            
      }
      
      @RequestMapping(value = "/delete-employee/{employeeId}", method = RequestMethod.DELETE)
      public ResponseEntity<Object> deleteEmployeeById(@PathVariable(value = "employeeId") long employeeId) throws ResourceNotFoundException {
          return employeeService.deleteEmployeeById(employeeId);
      }
      
      
}
