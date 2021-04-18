package com.videoGame.api.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.videoGame.api.entity.Products;

//Crud repo to access database table products
@Repository
@Transactional
public interface ProductsRepository extends CrudRepository<Products, Long> {
	public Products findById(long id);
	
    @Modifying
	@Query(nativeQuery = true, value = "delete from games_platform gp where gp.game_product_id = :id")
	public void deleteByJoinTable(@Param("id") long id);
}
