package com.videoGame.api.entity;

import java.sql.Date;
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

@Entity
public class Games {
	private Long id;
	private String name;
	private Date releaseDate;

	private Products products;
	private Set<Games> games;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
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
