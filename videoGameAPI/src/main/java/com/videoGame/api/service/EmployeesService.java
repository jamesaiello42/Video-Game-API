package com.videoGame.api.service;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.videoGame.api.entity.Employees;
import com.videoGame.api.repository.EmployeesRepository;

@Service
public class EmployeesService {
	@Autowired
	private EmployeesRepository repo;
	
	// Method gets all employees in the database
	public Iterable<Employees> getEmployees() {
		return repo.findAll();
	}
	
	// Method gets employee by id and tells user if it not found
	public Employees getEmpById(Long id) throws Exception {
		try {
			if (repo.findById(id).orElse(null) == null)
				throw new Exception("Unable to find employee");
			return repo.findById(id).orElse(null);
		} catch (Exception e) {
			throw new Exception("Unable to find employee");
		}
	}
	
	// Creates Employee record
	public Employees createEmp(Employees emp) throws AuthenticationException {
		
		// Create employee object and find employee to ensure username is not duplicated
		Employees newEmp = new Employees();
		Employees foundEmp = repo.findByUsername(emp.getUsername());
	
		// If no duplicate employee username is found, then set all the users table fields
		try {
			if (foundEmp == null) {
				newEmp.setUsername(emp.getUsername());
				newEmp.setSalt(BCrypt.gensalt());
				newEmp.setEmail(emp.getEmail());
				newEmp.setFirstName(emp.getFirstName());
				newEmp.setLastName(emp.getLastName());
				newEmp.setPassword(BCrypt.hashpw(emp.getPassword(), newEmp.getSalt()));
				newEmp.setRole(emp.getRole());
				newEmp.setSalary(emp.getSalary());
				newEmp.setHireDate(emp.getHireDate());
				repo.save(newEmp);
			}	
			return newEmp;
		}
		// Tell user username is taken
		catch (DataIntegrityViolationException e) {
			throw new AuthenticationException("That employee username is not avaiable.");
		}
		
	}
	
	// Update employee role, hire date, and salary
	public Employees updateEmp(Employees emp, Long id) throws Exception {
		// Find employee in the database
		Employees newEmp = repo.findById(id).orElse(null);
		
		// Prevent the update of employee that don't exist
		if (newEmp == null) {
			throw new Exception("Employee does not exist.");
		}
		
		// Set role, hire date, and salary and save to the database
		newEmp.setRole(emp.getRole());
		newEmp.setHireDate(emp.getHireDate());
		newEmp.setSalary(emp.getSalary());
		return repo.save(newEmp);
	}
	
	// Delete employee record
	public void deleteEmp(Long id) {
		repo.deleteById(id);
	}
}
