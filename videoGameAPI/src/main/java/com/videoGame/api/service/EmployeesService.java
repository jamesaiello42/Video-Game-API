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
	
	public Employees createEmp(Employees emp) throws AuthenticationException {
		Employees newEmp = new Employees();
		Employees foundEmp = repo.findByUsername(emp.getUsername());
	
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
		catch (DataIntegrityViolationException e) {
			throw new AuthenticationException("That employee username is not avaiable.");
		}
		
	}
}
