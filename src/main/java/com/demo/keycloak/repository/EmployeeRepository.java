package com.demo.keycloak.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.keycloak.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
}
