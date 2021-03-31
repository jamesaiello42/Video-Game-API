package com.videoGame.api.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Platforms {
	private Long id;
	private String name;
	private String vendor;
	private Date releaseDate;
	
	private Products products;
	private Set<Games> games;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "games_plaform",
		joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "platform_id", referencedColumnName = "id"))
	public Set<Games> getGames() {
		return games;
	}
	
	public void setGames(Set<Games> games) {
		this.games = games;
	}
}
