package com.videoGame.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoGame.api.entity.Products;
import com.videoGame.api.repository.ProductsRepository;

@Service
public class ProductsService {
	@Autowired
	private ProductsRepository repo;
	
	public Iterable<Products> getProducts() {
		return repo.findAll();
	}
	
	public Products createProductGame(Products products) {
		Products productGame = new Products();
		productGame.setUpc(products.getUpc());
		productGame.setPrice(products.getPrice());
		productGame.setNumberInStock(products.getNumberInStock());
		productGame.setProductType("Game");
		productGame.setGames(products.getGames());
		return repo.save(productGame);
	}
	
	public Products createProductPlatform(Products products) {
		Products productPlatform = new Products();
		productPlatform.setUpc(products.getUpc());
		productPlatform.setPrice(products.getPrice());
		productPlatform.setNumberInStock(products.getNumberInStock());
		productPlatform.setProductType("Platform");
		productPlatform.setPlatforms(products.getPlatforms());
		return repo.save(productPlatform);
	}
	
	public void deleteProduct(Long id) {
		repo.deleteById(id);
	}
	
}
