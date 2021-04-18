package com.videoGame.api.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.videoGame.api.entity.Games;
import com.videoGame.api.entity.Platforms;
import com.videoGame.api.service.GamesService;

@RestController
@RequestMapping("/games")
public class GamesController {
	
	@Autowired
	private GamesService service;
	
	// Update a game's name and release date by id
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateGame(@RequestBody Games game, @PathVariable Long id){
		try {
			return new ResponseEntity<Object>(service.updateGame(game, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	// Assign and relate a game to one or more platforms
	@RequestMapping(value = "/{id}/assignPlatform/", method = RequestMethod.POST)
	public ResponseEntity<Object> addProductPlatfrom(@RequestBody Set<Platforms> platform, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.assignPlatform(platform, id), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}
