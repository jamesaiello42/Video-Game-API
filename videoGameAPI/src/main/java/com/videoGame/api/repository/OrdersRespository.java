package com.videoGame.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.videoGame.api.entity.Orders;

public interface OrdersRespository extends CrudRepository<Orders, Long> {

}
