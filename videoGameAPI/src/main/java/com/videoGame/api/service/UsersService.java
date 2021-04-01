package com.videoGame.api.service;

import java.util.Set;

import javax.naming.AuthenticationException;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.videoGame.api.entity.Users;
import com.videoGame.api.entity.Orders;
import com.videoGame.api.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@OneToMany(mappedBy = "orders")
	private Set<Orders> items;
	
	public Users register(Users cred) throws AuthenticationException {
		Users user = new Users();
		Users foundUser = usersRepository.findByUsername(cred.getUsername());
	
		try {
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
		catch (DataIntegrityViolationException e) {
			throw new AuthenticationException("That username is not avaiable.");
		}
		
	}
	
	public Users login(Users cred) throws AuthenticationException {
		Users foundUser = usersRepository.findByUsername(cred.getUsername());
		if (foundUser != null && BCrypt.checkpw(cred.getPassword(), foundUser.getPassword())) {
			return foundUser;
		}
		throw new AuthenticationException("User not found or invalid password");
	}
	
	public Iterable<Users> getUsers() {
		return usersRepository.findAll();
	}
	
}