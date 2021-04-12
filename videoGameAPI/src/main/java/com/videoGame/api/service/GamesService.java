package com.videoGame.api.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoGame.api.entity.Games;
import com.videoGame.api.entity.Orders;
import com.videoGame.api.entity.Platforms;
import com.videoGame.api.entity.Products;
import com.videoGame.api.entity.Users;
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
			Set<Games> multiGames = new HashSet<>();

			if (games == null) {
				throw new Exception("Game does not exist.");
			}
			
			games.setPlatforms(platform);
			
			for (Platforms plat : platform) {
				multiGames.add(games);
			}
			
			
			
			return repo.save(games);
		} catch(Exception e) {
			throw e;
		}
	}
	
}
