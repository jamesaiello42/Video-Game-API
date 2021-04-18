package com.videoGame.api.repository;

import org.springframework.data.repository.CrudRepository;
import com.videoGame.api.entity.Games;

//Crud repo to access database table games
public interface GamesRepository extends CrudRepository<Games, Long> {
	public Games findById(long id);
	public Games findByName(String name);
}
