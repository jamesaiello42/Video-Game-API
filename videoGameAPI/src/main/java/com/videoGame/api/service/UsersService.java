package com.videoGame.api.service;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.videoGame.api.entity.Users;
import com.videoGame.api.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	// Create new user
	public Users register(Users cred) throws AuthenticationException {
		// Find user by username to see if it already exists
		Users user = new Users();
		Users foundUser = usersRepository.findByUsername(cred.getUsername());
	
		try {
			// Create user record if username is unique
			if (foundUser == null) {
				user.setUsername(cred.getUsername());
				user.setSalt(BCrypt.gensalt());
				user.setEmail(cred.getEmail());
				user.setFirstName(cred.getFirstName());
				user.setLastName(cred.getLastName());
				user.setPassword(BCrypt.hashpw(cred.getPassword(), user.getSalt()));
				usersRepository.save(user);
			}	
			return user;
		}
		// Tell user if username is taken
		catch (DataIntegrityViolationException e) {
			throw new AuthenticationException("That username is not avaiable.");
		}
		
	}
	
	// Method authenticates user credentials
	public Users login(Users cred) throws AuthenticationException {
		
		// Pull user from database and check if password is correct and user exists
		Users foundUser = usersRepository.findByUsername(cred.getUsername());
		if (foundUser != null && BCrypt.checkpw(cred.getPassword(), foundUser.getPassword())) {
			return foundUser;
		}
		// Tell user if password or user is invalid
		throw new AuthenticationException("User not found or invalid password");
	}
	
	
	// Find all users in database
	public Iterable<Users> getUsers() {
		return usersRepository.findAll();
	}
	
	// Find user by id in database
	public Users getUserById(Long id) throws Exception {
		try {
			// Check if is in the database
			if (usersRepository.findById(id).orElse(null) == null)
				throw new Exception("Unable to find user");
			
			// If found then return the json to the user
			return usersRepository.findById(id).orElse(null);
		} catch (Exception e) {
			throw new Exception("Unable to find user");
		}
	}
	
	// Delete user by id
	public void deleteUser(Long id) {
		usersRepository.deleteById(id);
	}
	
	
}
