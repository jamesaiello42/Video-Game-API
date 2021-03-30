package com.videoGame.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.videoGame.api.entity.Products;

public interface ProductsRepository extends CrudRepository<Products, Long> {
	public Products findById(long id);
}
