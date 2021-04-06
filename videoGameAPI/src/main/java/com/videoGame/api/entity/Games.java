package com.videoGame.api.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "platforms"})
public class Games {
	private Long id;
	private String name;
	private Date releaseDate;
	
	@JsonIgnore
	private Products products;
	
	private Set<Platforms> platforms;

	@Id
	@GeneratedValue(generator = "product_seq")
	@Column(name = "game_product_id")
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

	@OneToOne
	@JoinColumn(name = "game_product_id")
	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@ManyToMany
	@JoinTable(name = "games_platform",
			joinColumns = @JoinColumn(name = "game_product_id"),
			inverseJoinColumns = @JoinColumn(name = "platform_product_id"))
	public Set<Platforms> getPlatforms() {
		return platforms;
	}
	
	public void setPlatforms(Set<Platforms> platforms) {
		this.platforms = platforms;
	}
	
}
