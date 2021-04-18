package com.videoGame.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.videoGame.api.entity.Platforms;

//Crud repo to access database table platforms
public interface PlatformsRepository extends CrudRepository<Platforms, Long> {
	public Platforms findById(long id);
	public Platforms findByName(String name);
}
