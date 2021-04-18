package com.videoGame.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoGame.api.entity.Games;
import com.videoGame.api.entity.Platforms;
import com.videoGame.api.entity.Products;
import com.videoGame.api.repository.GamesRepository;
import com.videoGame.api.repository.PlatformsRepository;
import com.videoGame.api.repository.ProductsRepository;

@Service
public class ProductsService {
	@Autowired
	private ProductsRepository repo;
	
	@Autowired
	private PlatformsRepository platRepo;
	
	@Autowired
	private GamesRepository gamesRepo;
	
	// Returns all products in the database
	public Iterable<Products> getProducts() {
		return repo.findAll();
	}
	
	// Create new product of the type game
	public Products createProductGame(Products products) throws Exception {
		
		// Get game from db to check for duplicate name of game
		Games checkName = gamesRepo.findByName(products.getGames().getName());
		
		// Check for duplicate name of game
		// Let user know they are trying to insert a duplicate name into the database
		if (checkName != null) {
			throw new Exception("Product platform with the name " + checkName.getName() + " exists\n");
		}
		
		try {
				// Create new game by initializing all of its member variables
				Products productGame = new Products();
				productGame.setUpc("UPC-" + products.getUpc());
				productGame.setPrice(products.getPrice());
				productGame.setNumberInStock(products.getNumberInStock());
				productGame.setProductType("Game");
				productGame.setGames(products.getGames());
				return repo.save(productGame);
		}
		
		// Tell user that game product cannot be created
		catch(Exception e) {
			throw new Exception("Unable to create new game product");
		}
	}
	
	// Create new product of the type platform
	public Products createProductPlatform(Products products) throws Exception {
		try {
				// Find platform in database by name
				Platforms checkName = platRepo.findByName(products.getPlatforms().getName());
				
				// Let user know they are trying to insert a duplicate name into the database
				if (checkName != null) {
					throw new Exception("Product platform with the name " + checkName.getName() + " exists\n");
				}
				
				// Create new game by initializing all of its member variables
				Products productPlatform = new Products();
				productPlatform.setUpc("UPC-" + products.getUpc());
				productPlatform.setPrice(products.getPrice());
				productPlatform.setNumberInStock(products.getNumberInStock());
				productPlatform.setProductType("Platform");
				productPlatform.setPlatforms(products.getPlatforms());
				return repo.save(productPlatform);
		}
		// Tell user that game platform cannot be created
		catch(Exception e) {
			throw new Exception("Unable to create new platform product\n" + e.getMessage());
		}
	}
	
	// Gets by an id from the database
	public Products getProductById(Long id) throws Exception {
		try {
			// Find product and check if it found in the database
			if (repo.findById(id).orElse(null) == null)
				throw new Exception("Unable to find product");
			return repo.findById(id).orElse(null);
		} catch (Exception e) {
			throw new Exception("Unable to find product");
		}
	}
	
	// Delete products and clean up join table
	public void deleteProduct(Long id) {
		repo.deleteById(id);
		repo.deleteByJoinTable(id);
	}
	
}
