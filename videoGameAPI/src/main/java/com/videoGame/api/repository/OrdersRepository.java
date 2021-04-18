package com.videoGame.api.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.videoGame.api.entity.Orders;

//Crud repo to access database table orders
@Repository
@Transactional
public interface OrdersRepository extends CrudRepository<Orders, Long> {
	public Orders findById(long id);
	
	// Custom query to delete products_orders related rows
    @Modifying
	@Query(nativeQuery = true, value = "delete from products_orders o where o.orders_id = :id")
	public void deleteByJoinTableId(@Param("id") long id);
}
