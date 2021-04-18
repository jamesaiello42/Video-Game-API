package com.videoGame.api;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VideoGameApiApplication {

	public static void main(String[] args) {
		// Useful for timestamps to be correct 
		TimeZone.setDefault(TimeZone.getTimeZone("America/Chicago"));
		
		SpringApplication.run(VideoGameApiApplication.class, args);
	}

}
