package com.videoGame.api.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employees {
	// The following are stored in a table called employees within the video_games database
	private Long id;
	private String firstName;
	private String lastName;
	private Date hireDate;
	private Double salary;
	private String role;
	private String email;
	private String username;
	private String password;
	private String salt;
	
	// Getter for column id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	// Setter for column id
	public void setId(Long id) {
		this.id = id;
	}
	
	// Getter for column first_name
	public String getFirstName() {
		return firstName;
	}
	
	// Setter for column first_name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	// Getter for column last_name
	public String getLastName() {
		return lastName;
	}
	
	// Setter for column last_name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// Getter for column hire_date
	public Date getHireDate() {
		return hireDate;
	}
	
	// Setter for column hire_date
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	// Getter for column salary
	public Double getSalary() {
		return salary;
	}
	
	// Setter for column salary
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	// Getter for column role
	public String getRole() {
		return role;
	}
	
	// Setter for column role
	public void setRole(String role) {
		this.role = role;
	}
	
	// Getter for column email
	public String getEmail() {
		return email;
	}
	
	// Setter for column email
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Getter for column username
	public String getUsername() {
		return username;
	}
	
	// Setter for column username
	public void setUsername(String username) {
		this.username = username;
	}
	
	// Getter for column password
	public String getPassword() {
		return password;
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
}
