package com.videoGame.api.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
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
	private Long id;
	private int quantity;
	private Date dateOrdered;
	private double total;
	
	@JsonIgnore
	private Users users;
	
	private Set<Products> products;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Date getDateOrdered() {
		return dateOrdered;
	}
	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	
    public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@ManyToOne
    @JoinColumn(name = "buyer_id")
	public Users getUsers() {
		return users;
	}
    
	public void setUsers(Users users) {
		this.users = users;
	}
	
	@ManyToMany(mappedBy = "orders", cascade = CascadeType.ALL)
	public Set<Products> getProducts() {
		return products;
	}
	public void setProducts(Set<Products> products) {
		this.products = products;
	}
	
}
