package com.demo.keycloak.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.keycloak.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
	
	

}
