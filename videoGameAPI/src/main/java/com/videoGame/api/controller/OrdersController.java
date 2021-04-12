package com.videoGame.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.videoGame.api.entity.Orders;
import com.videoGame.api.service.OrdersService;

@RestController
@RequestMapping("users/{id}/orders")
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping(value="/createOrder", method=RequestMethod.POST)
	public ResponseEntity<Object> createOrder(@RequestBody Orders orders, @PathVariable Long id) throws Exception {
		return new ResponseEntity<Object>(ordersService.createOrder(orders, id), HttpStatus.CREATED);
	}
}
