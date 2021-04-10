package com.videoGame.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoGame.api.entity.Orders;
import com.videoGame.api.entity.Users;
import com.videoGame.api.repository.OrdersRepository;
import com.videoGame.api.repository.UsersRepository;

@Service
public class OrdersService {
	
	@Autowired
	private OrdersRepository repo;
	
	@Autowired
	private UsersRepository userRepo;
	
	public Orders createOrder(Orders orders, Long userId) throws Exception
	{
		Users users = userRepo.findById(userId).orElse(null);
		
		if (users == null) {
			throw new Exception("user not found.");
		}
		
		orders.setDateOrdered(new Date());
		orders.setQuantity(20);
		orders.setUsers(users);
		return repo.save(orders);
	}
	
}
