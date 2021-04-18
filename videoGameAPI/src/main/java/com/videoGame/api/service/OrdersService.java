package com.videoGame.api.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoGame.api.entity.Orders;
import com.videoGame.api.entity.Products;
import com.videoGame.api.entity.Users;
import com.videoGame.api.repository.OrdersRepository;
import com.videoGame.api.repository.ProductsRepository;
import com.videoGame.api.repository.UsersRepository;

@Service
public class OrdersService {
	
	@Autowired
	private OrdersRepository repo;
	
	@Autowired
	private UsersRepository userRepo;
	
	@Autowired
	private ProductsRepository productRepo;
	
	// Create new order
	public Orders createOrder(Orders orders, Long userId) throws Exception
	{
		try {
			
			// Pulls user from the database
			Users user = userRepo.findById(userId).orElse(null);
			
			// Prevent order being created under no user
			if (user == null) {
				throw new Exception("Cannot create an order under a user that does not exist");
			}
			
			// return new order object to be save into the db
			Orders order = intializeNewOrder(orders, user);
			return repo.save(order);
		} catch(Exception e) {
			throw e;
		}
	}
	
	// Delete an order from the database
	public void deleteOrders(Long userId, Long orderId) throws Exception {
		// Check if user exists or not, if not don't delete order
		if (userRepo.findById(userId).orElse(null) == null) {
			throw new Exception("Order does not exist under this user");
		}
		
		// Implemented custom method to prevent deleting of products. We want to clean up the products in the join table only
		repo.deleteById(orderId);
		repo.deleteByJoinTableId(orderId);
	}
	
/*	public Orders updateOrder(Orders orders, Long userId, Long orderId) {
		try {
			Users user = userRepo.findById(userId).orElse(null);
			Orders order = repo.findById(orderId).orElse(null);
			order.setId(orderId);
			order.setUsers(user);
			return repo.save(order);
		} catch(Exception e) {
			throw e;
		}
	}*/
	
	// Function creates new order and returns new object that is then returned to be saved into the db 
	private Orders intializeNewOrder(Orders order, Users user) throws Exception {		
		Orders orders = new Orders(); 
		orders.setProducts(convertToProductSet(order));
		orders.setDateOrdered(new Date());
		orders.setQuantity(orders.getProducts().size());
		orders.setUsers(user);
		addOrderToProducts(orders);
		orders.setTotal(calculateTotal(orders.getProducts()));
		return orders;
	}

	// Helper function calculates order totals 
	private double calculateTotal(Set<Products> products) {
		double total = 0.0;
		
		for(Products product : products) {
			total += product.getPrice();
		}
		
		return total;
	}

	// Converts product ids into Set of products
	private Set<Products> convertToProductSet(Orders orders) throws Exception {
		Set<Long> productIds = new HashSet<Long>();
		Iterable<Products> iterable;
		
		// Keeps track of product count to make sure there are 1 or more products passed in
		int productCnt = 0;
		
		// Create set of ids
		for (Products products : orders.getProducts()) {
			productIds.add(products.getId());
		}
		
		// Find all products in the database with ids passed and create empty set of products
		iterable = productRepo.findAllById(productIds);
		Set<Products> set = new HashSet<Products>();
		
		// Intialize set of products and check if item is out of stock
		for(Products product : iterable) {
			if (product.getNumberInStock() - 1 < 0)
				throw new Exception("Item out of stock");
			else {	
				product.setNumberInStock(product.getNumberInStock() - 1);
				set.add(product);
			}			
			productCnt++;
		}
		
		// Check if no actual existing products ids are passed in
		if (productCnt == 0) 
			throw new Exception("Request has no actual products id that exist");
		
		return set;
	}
	
	// This function is here to ensure many-many relationship puts related records in join table
	private void addOrderToProducts(Orders order) {
		Set<Products> products = order.getProducts();
		for (Products product : products) {
			product.getOrders().add(order);
		}
	}
	
}
