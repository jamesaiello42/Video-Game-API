package com.videoGame.api.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;

import com.videoGame.api.entity.Products;

@Primary
public interface ProductsRepository extends CrudRepository<Products, Long> {
	public Products findById(long id);
}
