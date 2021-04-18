package com.videoGame.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.videoGame.api.entity.Platforms;
import com.videoGame.api.repository.PlatformsRepository;

@Service
public class PlatformsService {
	@Autowired
	private PlatformsRepository repo;
	
	// Updates platform's name, vendor, and release date
	public Platforms updateGame(Platforms platform, Long id) throws Exception {
		
		// Search for platform record in database and check if is exists
		Platforms platforms = repo.findById(id).orElse(null);
		if (platforms == null) {
			throw new Exception("Platform does not exist.");
		}
		
		// Set name, vendor, and release date
		platforms.setName(platform.getName());
		platforms.setVendor(platform.getVendor());
		platforms.setReleaseDate(platform.getReleaseDate());
		return repo.save(platforms);
	}
}
