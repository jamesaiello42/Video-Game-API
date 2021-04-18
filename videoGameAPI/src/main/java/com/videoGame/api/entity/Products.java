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
	
	// Fields are contained within the products table
	private Long id;
	private String upc;
	private Double price;
	private int numberInStock;
	private String productType;

	// Games and platforms entities
	private Games games;	
	private Platforms platforms;

	// Prevent infinite JSON loop
	@JsonIgnore
	private Set<Orders> orders;

	// Getter for column id. A generator was used to track id numbering between table games and platforms and products
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "product_seq")
	public Long getId() {
		return id;
	}

	// Setter for column id
	public void setId(Long id) {
		this.id = id;
	}

	// Getter for column upc and upc is made unique to disallow dups
	@Column(unique = true, length = 50)
	public String getUpc() {
		return upc;
	}

	// Setter for column upc
	public void setUpc(String upc) {
		this.upc = upc;
	}

	// Getter for column price
	public Double getPrice() {
		return price;
	}

	// Setter for column price
	public void setPrice(Double price) {
		this.price = price;
	}

	// Getter for column number_in_stock
	public int getNumberInStock() {
		return numberInStock;
	}

	// Setter for column number_in_stock
	public void setNumberInStock(int numberInStock) {
		this.numberInStock = numberInStock;
	}

	// Getter for column product_type
	public String getProductType() {
		return productType;
	}

	// Setter for column product_type
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	// Getter for related table games records. This one-to-one relationship ensures CRUD operations where correctly between products and games tables
	@OneToOne(mappedBy = "products", cascade = CascadeType.ALL)
	public Games getGames() {
		return games;
	}

	// Setter for related table games records
	public void setGames(Games games) {
		this.games = games;
	}

	// Getter for related table platforms records. This one-to-one relationship ensures CRUD operations where correctly between products and platform tables
	@OneToOne(mappedBy = "products", cascade = CascadeType.ALL)
	public Platforms getPlatforms() {
		return platforms;
	}

	// Setter for related table platforms records
	public void setPlatforms(Platforms platforms) {
		this.platforms = platforms;
	}

	// Getter for orders entity and products_orders join table is created. Many orders can have many products
	@ManyToMany
	   @JoinTable(name = "products_orders",
       joinColumns = @JoinColumn(name = "products_id", referencedColumnName = "id"),
       inverseJoinColumns = @JoinColumn(name = "orders_id", referencedColumnName = "id"))
	public Set<Orders> getOrders() {
		return orders;
	}

	// Setter for orders entity
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

}
