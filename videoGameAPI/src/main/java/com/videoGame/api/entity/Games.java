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

	@Temporal(TemporalType.DATE)
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

	@ManyToMany(mappedBy = "games", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<Platforms> getPlatforms() {
		return platforms;
	}
	
	public void setPlatforms(Set<Platforms> platforms) {
		this.platforms = platforms;
	}
	
}
