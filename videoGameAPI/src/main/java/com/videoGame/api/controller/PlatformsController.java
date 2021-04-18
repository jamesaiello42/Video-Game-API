package com.videoGame.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.videoGame.api.entity.Platforms;
import com.videoGame.api.service.PlatformsService;

@RestController
@RequestMapping("/platforms")
public class PlatformsController {
	@Autowired
	private PlatformsService service;
	
	// Update a platform's name, vendor, and release date by id
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updatePlatform(@RequestBody Platforms platforms, @PathVariable Long id){
		try {
			return new ResponseEntity<Object>(service.updateGame(platforms, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
