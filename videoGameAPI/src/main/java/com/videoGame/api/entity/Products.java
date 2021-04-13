package com.videoGame.api.entity;

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
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Products {
	private Long id;
	private String upc;
	private Double price;
	private int numberInStock;
	private String productType;

	private Games games;
	
	private Platforms platforms;

	@JsonIgnore
	private Set<Orders> orders;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "product_seq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(unique = true, length = 50)
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

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
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

	@ManyToMany
	   @JoinTable(name = "products_orders",
       joinColumns = @JoinColumn(name = "products_id", referencedColumnName = "id"),
       inverseJoinColumns = @JoinColumn(name = "orders_id", referencedColumnName = "id"))
	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

}
