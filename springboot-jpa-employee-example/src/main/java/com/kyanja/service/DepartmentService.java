package com.kyanja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kyanja.exception.ResourceNotFoundException;
import com.kyanja.model.Department;
import com.kyanja.model.Department;
import com.kyanja.repository.DepartmentDao;

@Service
@Transactional
public class DepartmentService {
	
	@Autowired
	DepartmentDao departmentDao;
	
	 public List<Department> getDepartments() {
	        return departmentDao.findAll();
	    }

	 
	 public Department createDepartment(Department department) {
	        return departmentDao.save(department);
	    }
	 

	    public Optional<Department> getDepartmentById(Long departmentId) throws ResourceNotFoundException {
	        if (!departmentDao.existsById(departmentId)) {
	            throw new ResourceNotFoundException("Department with id " + departmentId + " not found");
	        }
	        return departmentDao.findById(departmentId);
	    }
	 
	    public Department updateDepartmentById(Long departmentId, Department departmentRequest) throws ResourceNotFoundException {
	        if (!departmentDao.existsById(departmentId)) {
	            throw new ResourceNotFoundException("department with id " + departmentId + " not found");
	        }
	        Optional<Department> department = departmentDao.findById(departmentId);

	        if (!department.isPresent()) {
	            throw new ResourceNotFoundException("Department with id " + departmentId + " not found");
	        }

	        Department department1 = department.get();
	        department1.setName(departmentRequest.getName());
	        
	        return departmentDao.save(department1);

	    }

	    public ResponseEntity<Object> deleteDepartmentById(long departmentId) throws ResourceNotFoundException {
	        if (!departmentDao.existsById(departmentId)) {
	            throw new ResourceNotFoundException("Department with id " + departmentId + " not found");
	        }

	        departmentDao.deleteById(departmentId);

	        return ResponseEntity.ok().build();

	    }

	    
	    
}
