package com.videoGame.api.controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.videoGame.api.entity.Users;
import com.videoGame.api.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	// Creates a new user
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<Object> register(@RequestBody Users cred) {
		try {
			return new ResponseEntity<Object>(usersService.register(cred), HttpStatus.CREATED);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	// Authenticates a user, logs them in
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public ResponseEntity<Object> login(@RequestBody Users cred) {
		try {
			return new ResponseEntity<Object>(usersService.login(cred), HttpStatus.OK);
		} catch (AuthenticationException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}
	
	// Gets all users from the database
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getUsers() {
		return new ResponseEntity<Object>(usersService.getUsers(), HttpStatus.OK);
	}
	
	// Returns a single user based on an id
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getCustomer(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(usersService.getUserById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	// Deletes a single user by an id
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
		try {
			usersService.deleteUser(id);
			return new ResponseEntity<Object>("Successful deleted user of id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete user", HttpStatus.BAD_REQUEST);
		}
	}	
	
}
