package com.videoGame.api.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Orders {
	private Long id;
	private int quantity;
	private Date dateOrdered;
	
	private Users users;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id")
	public Users getUsers() {
		return users;
	}
    
	public void setUsers(Users users) {
		this.users = users;
	}
	
}
