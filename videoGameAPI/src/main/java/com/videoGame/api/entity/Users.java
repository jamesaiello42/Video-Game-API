package com.videoGame.api.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Users {
	
	// These are columns in the users table
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String salt;
	
	// A user can have orders tied to them
	private Set<Orders> orders;
	
	// Getter for column id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	// Getter for column username
	public String getUsername() {
		return username;
	}
	
	// Getter for column first_name
	public String getFirstName() {
		return firstName;
	}
	
	// Getter for column last_name
	public String getLastName() {
		return lastName;
	}
	
	// Getter for column email
	public String getEmail() {
		return email;
	}
	
	// Getter for column password
	public String getPassword() {
		return password;
	}
	
	// Setter for column id
	public void setId(Long id) {
		this.id = id;
	}
	
	// Setter for column username
	public void setUsername(String username) {
		this.username = username;
	}
	
	// Setter for column first_name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	// Setter for column last_name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// Setter for column email
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Setter for column password
	public void setPassword(String password) {
		this.password = password;
	}
	
	// Getter for column salt
	public String getSalt() {
		return salt;
	}
	
	// Setter for column salt
	public void setSalt(String salt) {
		this.salt = salt;
	}

	// Getter for entity order. One user can have many orders
	@OneToMany(mappedBy = "users")
	public Set<Orders> getOrders() {
		return orders;
	}

	// Setter for entity orders
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	
}
