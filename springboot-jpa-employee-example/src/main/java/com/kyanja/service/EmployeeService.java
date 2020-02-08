package com.kyanja.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kyanja.exception.ResourceNotFoundException;
import com.kyanja.model.Department;
import com.kyanja.model.Employee;
import com.kyanja.repository.DepartmentDao;
import com.kyanja.repository.EmployeeDao;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
    
    
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    
    public Optional<Employee> getEmployeeById(Long employeeId) throws ResourceNotFoundException {
        if (!employeeDao.existsById(employeeId)) {
            throw new ResourceNotFoundException("Employee with id " + employeeId + " not found");
        }
        return employeeDao.findById(employeeId);
    }
    

    public Employee createEmployee(Long id, Employee employee) throws ResourceNotFoundException {
        Set<Employee> employees = new HashSet<Employee>();
        Department department1 = new Department();

        Optional<Department> byId = departmentDao.findById(id);
        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("Department with id " + id + " does not exist");
        }
        
        Department   department = byId.get();
        
        employee.setDepartment(department);
        
        Employee employee1 = employeeDao.save(employee);
        
        employees.add(employee1);
        department1.setEmployees(employees);
        
        return employee1;



    }
    
    
    public Employee updateEmployeeById(Long departmentId, Long employeeId, Employee  employeeRequest) throws ResourceNotFoundException {
       
    	
    	if (! employeeDao.existsById(employeeId)) {
            throw new ResourceNotFoundException("Employee with id " + employeeId + " not found");
        }
        Optional<Employee> employee = employeeDao.findById(employeeId);
        
        if(!departmentDao.existsById(departmentId)) {
            throw new ResourceNotFoundException("Department with id" + departmentId + " not found");
            
        }
        
//        Optional<Department> department = departmentDao.findById(departmentId);
        
        Department department1 = departmentDao.getOne(departmentId);

        if (!employee.isPresent()) {
            throw new ResourceNotFoundException("Employee with id " + employeeId + " not found");
        }

        Employee employee1 = employee.get();
        employee1.setName(employeeRequest.getName());
        employee1.setDesignation(employeeRequest.getDesignation());
        employee1.setSalary(employeeRequest.getSalary());
        employee1.setDepartment(department1 );
        
        return employeeDao.save(employee1);

  
    }
    
    public ResponseEntity<Object> deleteEmployeeById(long employeeId) throws ResourceNotFoundException {
        if (!employeeDao.existsById(employeeId)) {
            throw new ResourceNotFoundException("Employee with id " + employeeId + " not found");
        }

            employeeDao.deleteById(employeeId);

        return ResponseEntity.ok().build();

    }
}
