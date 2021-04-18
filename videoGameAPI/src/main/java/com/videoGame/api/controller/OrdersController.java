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
@RequestMapping("users/{userId}/orders")
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	// Create a new order for a customer
	@RequestMapping(value="/createOrder", method=RequestMethod.POST)
	public ResponseEntity<Object> createOrder(@RequestBody Orders orders, @PathVariable Long userId) throws Exception {
		return new ResponseEntity<Object>(ordersService.createOrder(orders, userId), HttpStatus.CREATED);
	}
	
	// Delete an order
	@RequestMapping(value = "/{orderId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteOrder(@PathVariable Long userId, @PathVariable Long orderId) {
		try {
			ordersService.deleteOrders(userId, orderId);
			return new ResponseEntity<Object>("Successful delete order of id: " + orderId, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Unable to delete order \n" + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

/*	@RequestMapping(value="/updateOrder/{orderId}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateOrder(@RequestBody Orders orders, @PathVariable Long userId, @PathVariable Long orderId) throws Exception {
		return new ResponseEntity<Object>(ordersService.updateOrder(orders, userId, orderId), HttpStatus.OK);
	}*/
}
