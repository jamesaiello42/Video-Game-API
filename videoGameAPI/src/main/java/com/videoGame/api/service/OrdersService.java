package com.videoGame.api.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.criteria.Order;

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
	
	
	public Orders createOrder(Orders orders, Long userId) throws Exception
	{
		try {
			Users user = userRepo.findById(userId).orElse(null);
			Orders order = intializeNewOrder(orders, user);
			return repo.save(order);
		} catch(Exception e) {
			throw e;
		}
	}
	
	private Orders intializeNewOrder(Orders order, Users user) {		
		Orders orders = new Orders(); 
		
		orders.setProducts(convertToProductSet(order));
		orders.setDateOrdered(new Date());
		orders.setQuantity(order.getProducts().size());
		orders.setUsers(user);
		addOrderToProducts(orders);
		orders.setTotal(calculateTotal(orders.getProducts()));
		return orders;
	}

	private double calculateTotal(Set<Products> products) {
		double total = 0.0;
		
		for(Products product : products) {
			total += product.getPrice();
		}
		
		return total;
	}

	private Set<Products> convertToProductSet(Orders orders) {
		Set<Long> productIds = new HashSet<Long>();
		Iterable<Products> iterable;
		
		for (Products products : orders.getProducts()) {
			productIds.add(products.getId());
		}
		
		iterable = productRepo.findAllById(productIds);
		Set<Products> set = new HashSet<Products>();
		for(Products product : iterable) {
			set.add(product);	
		}
		
		return set;
	}
	
	private void addOrderToProducts(Orders order) {
		Set<Products> products = order.getProducts();
		for (Products product : products) {
			product.getOrders().add(order);
		}
	}
	
}
