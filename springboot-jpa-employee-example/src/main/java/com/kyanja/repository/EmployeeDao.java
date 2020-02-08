package com.kyanja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kyanja.model.Employee;

@Repository
public interface EmployeeDao   extends JpaRepository<Employee, Long> {

}
