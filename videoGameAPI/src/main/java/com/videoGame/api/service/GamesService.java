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
	
	public Games updateGame(Games game, Long id) throws Exception {
		Games games = repo.findById(id).orElse(null);
		if (games == null) {
			throw new Exception("Game does not exist.");
		}
		
		games.setName(game.getName());
		games.setReleaseDate(game.getReleaseDate());
		return repo.save(games);
	}
	
	public Games assignPlatform(Set<Platforms> platform, Long id) throws Exception {
		try {
			Games games = repo.findById(id).orElse(null);
			Set<Platforms> newPlatform = new HashSet<Platforms>();
			Set<Long> platIds = new HashSet<Long>();
			
			for (Platforms plat : platform) {
				platIds.add(plat.getId());
			}
			
			Iterable<Platforms> platforms = platformRepo.findAllById(platIds);

			if (games == null || platforms == null) {
				throw new Exception("Game does not exist.");
			}
			
			for (Platforms plat : platforms) {
				newPlatform.add(plat);
			}
			
			
			games.setPlatforms(newPlatform);
			addPlatformToGames(games);
			return repo.save(games);
		} catch(Exception e) {
			throw e;
		}
	}
	
	private void addPlatformToGames(Games games) {
		Set<Platforms> platforms = games.getPlatforms();
		for (Platforms platform : platforms) {
			platform.getGames().add(games);
		}
	}
	
}
