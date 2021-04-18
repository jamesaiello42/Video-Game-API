package com.videoGame.api.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Platforms {
	
	// Table platforms contains these class variables
	private Long id;
	private String name;
	private String vendor;
	private Date releaseDate;
	
	// Prevents JSON recursion
	@JsonIgnore
	private Products products;
	
	// Prevents JSON recursion
	@JsonIgnore
	private Set<Games> games;
	
	// Getter for column id. A generator was used to track id numbering between table games and platforms
	@Id
	@GeneratedValue(generator = "product_seq")
	@Column(name = "platform_product_id")
	public Long getId() {
		return id;
	}
	
	// Setter for column id
	public void setId(Long id) {
		this.id = id;
	}

	// Getter for column name
	public String getName() {
		return name;
	}
	
	// Setter for column name
	public void setName(String name) {
		this.name = name;
	}
	
	// Getter for column vendor
	public String getVendor() {
		return vendor;
	}
	
	// Setter for column vendor
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	// Getter for column release_date. Temporal annotation makes the column a SQL Date.
	@Temporal(TemporalType.DATE)
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	// Setter for column release_date.
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	// Getter for related table platforms records. This one-to-one relationship ensures CRUD operations where correctly between products and platforms tables
	@OneToOne
	@JoinColumn(name = "platform_product_id")
	public Products getProducts() {
		return products;
	}
	
	// Setter for related table platforms records
	public void setProducts(Products products) {
		this.products = products;
	}
	
	// Getter for games entity and creates a join table games_platform. Many platforms can have many games
	@ManyToMany
	@JoinTable(name = "games_platform",
		joinColumns = @JoinColumn(name = "platform_product_id"),
		inverseJoinColumns = @JoinColumn(name = "game_product_id"))
	public Set<Games> getGames() {
		return games;
	}
	
	// Setter for games entity
	public void setGames(Set<Games> games) {
		this.games = games;
	}
}
