package com.videoGame.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createEmp(@RequestBody Employees emp) {
		try {
			return new ResponseEntity<Object>(empService.createEmp(emp), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
