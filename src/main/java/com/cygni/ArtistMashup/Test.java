package com.cygni.ArtistMashup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/{id}")
public class Test {

    private static final String TEST = "http://musicbrainz.org/ws/2/artist/{id}?&fmt=json&inc=url-rels+release-groups";

    @GetMapping
    public Mono<String> getArtist(@PathVariable("id") String id) {
        RestTemplate restTemplate = new RestTemplate();

        String s = restTemplate.getForObject(TEST, String.class, id);

        return Mono.justOrEmpty(s).switchIfEmpty(
                Mono.error(new RuntimeException()));
    }
}
