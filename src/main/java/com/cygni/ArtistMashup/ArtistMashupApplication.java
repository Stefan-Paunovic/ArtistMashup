package com.cygni.ArtistMashup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ArtistMashupApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtistMashupApplication.class, args);
	}

}
