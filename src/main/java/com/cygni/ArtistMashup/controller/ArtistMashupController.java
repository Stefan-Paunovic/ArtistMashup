package com.cygni.ArtistMashup.controller;

import com.cygni.ArtistMashup.service.MusicBrainzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/artist")
public class ArtistMashupController {

    @Autowired
    MusicBrainzService musicBrainzService;

    @GetMapping(value = "/{id}")
    public Mono<String> getArtist(@PathVariable("id") String id) {

        Mono<String> test = musicBrainzService.getArtist(id);

        if(test != null) {
            return test;
        }
        return null;

    }



/*

    @GetMapping(value = "/{id}")
    public Mono<String> getArtist(@PathVariable("id") String id) {
        RestTemplate restTemplate = new RestTemplate();

        String s = restTemplate.getForObject(TEST, String.class, id);

        return Mono.justOrEmpty(s).switchIfEmpty(
                Mono.error(new RuntimeException()));
    }

 */





}