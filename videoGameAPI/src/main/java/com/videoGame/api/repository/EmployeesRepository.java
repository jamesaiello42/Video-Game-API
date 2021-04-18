package com.videoGame.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.videoGame.api.entity.Employees;

// Crud repo to access database table employees
public interface EmployeesRepository extends CrudRepository<Employees, Long> {
	public Employees findById(long id);
	public Employees findByUsername(String username);
}
