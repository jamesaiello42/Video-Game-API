package com.videoGame.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.videoGame.api.entity.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Long> {
	public Orders findById(long id);
}
