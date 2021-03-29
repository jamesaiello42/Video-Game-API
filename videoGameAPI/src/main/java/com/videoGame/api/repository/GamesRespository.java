package com.videoGame.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.videoGame.api.entity.Games;

public interface GamesRespository extends CrudRepository<Games, Long> {

}
