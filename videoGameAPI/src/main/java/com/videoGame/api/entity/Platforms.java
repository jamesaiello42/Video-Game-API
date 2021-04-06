package com.videoGame.api.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

public class Platforms {
	private Long id;
	private String name;
	private String vendor;
	private Date releaseDate;
	
	@JsonIgnore
	private Products products;
	
	private Set<Games> games;
	
	@Id
	@GeneratedValue(generator = "product_seq")
	@Column(name = "platform_product_id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(unique = true, length = 50)
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
	
	@Temporal(TemporalType.DATE)
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	@OneToOne
	@JoinColumn(name = "platform_product_id")
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	
	@ManyToMany
	@JoinTable(name = "games_platform",
		joinColumns = @JoinColumn(name = "platform_product_id"),
		inverseJoinColumns = @JoinColumn(name = "game_product_id"))
	public Set<Games> getGames() {
		return games;
	}
	
	public void setGames(Set<Games> games) {
		this.games = games;
	}
}
