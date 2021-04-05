package com.videoGame.api;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VideoGameApiApplication {

	public static void main(String[] args) {
		// Useful for timestamps to be correct 
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		
		SpringApplication.run(VideoGameApiApplication.class, args);
	}

}
