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
	
	public Products createProduct(Products products) {
		return repo.save(products);
	}
	
}
