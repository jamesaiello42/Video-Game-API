package com.videoGame.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.videoGame.api.entity.Employees;
import com.videoGame.api.service.EmployeesService;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
	@Autowired
	private EmployeesService empService;
	
	// Gets all employees
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployees() {
		return new ResponseEntity<Object>(empService.getEmployees(), HttpStatus.OK);
	}
	
	// Gets one employee by an id
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmp(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(empService.getEmpById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	// Creates an employee
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createEmp(@RequestBody Employees emp) {
		try {
			return new ResponseEntity<Object>(empService.createEmp(emp), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	// Updates an employee salary, hire date, and role by id
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateEmp(@RequestBody Employees emp, @PathVariable Long id){
		try {
			return new ResponseEntity<Object>(empService.updateEmp(emp, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	// Delete employee by id
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
		try {
			empService.deleteEmp(id);
			return new ResponseEntity<Object>("Successful deleted employee of id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete employee", HttpStatus.BAD_REQUEST);
		}
	}
	
}
