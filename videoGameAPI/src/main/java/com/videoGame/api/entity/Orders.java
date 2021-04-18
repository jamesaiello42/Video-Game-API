package com.videoGame.api.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Orders {
	// These fields are columns for the table orders
	private Long id;
	private int quantity;
	private Date dateOrdered;
	private double total;
	
	// Prevents serialization recursion
	@JsonIgnore
	private Users users;
	
	private Set<Products> products;
	
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
	
	// Getter for column quantity
	public int getQuantity() {
		return quantity;
	}
	
	// Setter for column quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	// Getter for column date_ordered
	public Date getDateOrdered() {
		return dateOrdered;
	}
	
	// Setter for column date_ordered
	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	
	// Setter for column total
    public double getTotal() {
		return total;
	}
    
    // Getter for column total
	public void setTotal(double total) {
		this.total = total;
	}
	
	// Getter for users entity. One user can have many order
	@ManyToOne
    @JoinColumn(name = "buyer_id")
	public Users getUsers() {
		return users;
	}
    
	// Setter for users entity
	public void setUsers(Users users) {
		this.users = users;
	}
	
	// Getter for products entity. Many orders can have many products
	@ManyToMany(mappedBy = "orders")
	public Set<Products> getProducts() {
		return products;
	}
	
	// Setter for products entity
	public void setProducts(Set<Products> products) {
		this.products = products;
	}
	
}
