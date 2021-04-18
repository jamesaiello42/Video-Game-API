package com.videoGame.api.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoGame.api.entity.Games;
import com.videoGame.api.entity.Platforms;
import com.videoGame.api.repository.GamesRepository;
import com.videoGame.api.repository.PlatformsRepository;

@Service
public class GamesService {
	@Autowired
	private GamesRepository repo;
	
	@Autowired
	private PlatformsRepository platformRepo;
	
	// Function updates game name and release date
	public Games updateGame(Games game, Long id) throws Exception {
		
		// Find game and check if game exists
		Games games = repo.findById(id).orElse(null);
		if (games == null) {
			throw new Exception("Game does not exist.");
		}
		
		// Set game name and release date
		games.setName(game.getName());
		games.setReleaseDate(game.getReleaseDate());
		return repo.save(games);
	}
	
	// Assign many platforms to one game
	public Games assignPlatform(Set<Platforms> platform, Long id) throws Exception {
		try {
			
			// Get a game by id, set up empty platforms Set object, and empty platforms id set
			Games games = repo.findById(id).orElse(null);
			Set<Platforms> newPlatform = new HashSet<Platforms>();
			Set<Long> platIds = new HashSet<Long>();
			
			// Initialize platforms id set with platforms ids from json call
			for (Platforms plat : platform) {
				platIds.add(plat.getId());
			}
			
			// Pull all platforms matching the ids given 
			Iterable<Platforms> platforms = platformRepo.findAllById(platIds);

			// Check if games or platforms are correct
			if (games == null || platforms == null) {
				throw new Exception("Game or platform does not exist.");
			}
			
			// Initialize platforms set with platforms found in the database
			for (Platforms plat : platforms) {
				newPlatform.add(plat);
			}
			
			// Set game objects with set of platform objects 
			games.setPlatforms(newPlatform);
			addPlatformToGames(games);
			return repo.save(games);
		} catch(Exception e) {
			throw e;
		}
	}
	
	// This function is here to ensure many-many relationship puts related records in join table
	private void addPlatformToGames(Games games) {
		Set<Platforms> platforms = games.getPlatforms();
		for (Platforms platform : platforms) {
			platform.getGames().add(games);
		}
	}
	
}
