package com.videoGame.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.videoGame.api.entity.Products;
import com.videoGame.api.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	// Gets all products stored in the database
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getProducts() {
		return new ResponseEntity<Object>(productsService.getProducts(), HttpStatus.OK);
	}
	
	// Gets one product by id
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getProduct(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(productsService.getProductById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	// Creates a new game
	@RequestMapping(value = "/create/game", method = RequestMethod.POST)
	public ResponseEntity<Object> addProductGame(@RequestBody Products products) {
		try {
			return new ResponseEntity<Object>(productsService.createProductGame(products), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	// Creates a new platform
	@RequestMapping(value = "/create/platform", method = RequestMethod.POST)
	public ResponseEntity<Object> addProductPlatfrom(@RequestBody Products products) {
		try {
			return new ResponseEntity<Object>(productsService.createProductPlatform(products), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	// Deletes a product from the database
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
		try {
			productsService.deleteProduct(id);
			return new ResponseEntity<Object>("Successful delete product of id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete product", HttpStatus.BAD_REQUEST);
		}
	}
}
