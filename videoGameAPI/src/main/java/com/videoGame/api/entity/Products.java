package com.videoGame.api.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Products {
	private Long id;
	private String upc;
	private Double price;
	private int numberInStock;
	
    private Games games;
	
    private Platforms platforms;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getNumberInStock() {
		return numberInStock;
	}
	public void setNumberInStock(int numberInStock) {
		this.numberInStock = numberInStock;
	}
	
	@OneToOne(mappedBy = "products", cascade = CascadeType.ALL)
	public Games getGames() {
		return games;
	}
	
	public void setGames(Games games) {
		this.games = games;
	}
	
	@OneToOne(mappedBy = "products", cascade = CascadeType.ALL)
	public Platforms getPlatforms() {
		return platforms;
	}
	public void setPlatforms(Platforms platforms) {
		this.platforms = platforms;
	}
		
}
