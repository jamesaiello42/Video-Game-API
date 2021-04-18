package com.videoGame.api.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Games {
	
	// Fields are columns in the games table
	private Long id;
	private String name;
	private Date releaseDate;
	
	// JsonIgnore prevents recursion
	@JsonIgnore
	private Products products;
	
	private Set<Platforms> platforms;

	// Getter for column id. A generator was used to track id numbering between table games and platforms
	@Id
	@GeneratedValue(generator = "product_seq")
	@Column(name = "game_product_id")
	public Long getId() {
		return id;
	}

	// Setter for column id
	public void setId(Long id) {
		this.id = id;
	}
	
	// Getter for column name.
	public String getName() {
		return name;
	}

	// Setter for column id.
	public void setName(String name) {
		this.name = name;
	}

	// Getter for column release_date. Temporal annotation makes the column a SQL Date.
	@Temporal(TemporalType.DATE)
	public Date getReleaseDate() {
		return releaseDate;
	}

	// Setter for column release_date
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	// Getter for related table games records. This one-to-one relationship ensures CRUD operations where correctly between products and games tables
	@OneToOne
	@JoinColumn(name = "game_product_id")
	public Products getProducts() {
		return products;
	}

	// Setter for products table.
	public void setProducts(Products products) {
		this.products = products;
	}

	// Getter for platforms entity. Many games can have many platforms
	@ManyToMany(mappedBy = "games", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<Platforms> getPlatforms() {
		return platforms;
	}
	
	// Setter for platforms entity.
	public void setPlatforms(Set<Platforms> platforms) {
		this.platforms = platforms;
	}
	
}
