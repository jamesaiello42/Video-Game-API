package com.videoGame.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.videoGame.api.entity.Products;

public interface ProductsRespository extends CrudRepository<Products, Long> {

}
