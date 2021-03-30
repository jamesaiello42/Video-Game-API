package com.videoGame.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.videoGame.api.entity.Games;

public interface GamesRepository extends CrudRepository<Games, Long> {
	public Games findById(long id);
}
