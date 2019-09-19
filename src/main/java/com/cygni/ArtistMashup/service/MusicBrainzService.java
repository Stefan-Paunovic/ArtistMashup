package com.cygni.ArtistMashup.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@Service
public class MusicBrainzService {
    private static Logger LOGGER = LoggerFactory.getLogger(MusicBrainzService.class);

    private static final String QUERY_PATH =
            "http://musicbrainz.org/ws/2/artist/{mbid}?&fmt=json&inc=url-rels+release-groups";

    private static final String TEST = "http://musicbrainz.org/ws/2/artist/5b11f4ce-a62d-471e-81fc-a69a8278c7da?&fmt=json&inc=url-rels+release-groups";

    public Mono<String> getArtist(final String id) {
        RestTemplate restTemplate = new RestTemplate();

        String s = restTemplate.getForObject(TEST, String.class, id);

        return Mono.justOrEmpty(s).switchIfEmpty(
                Mono.error(new RuntimeException()));
    }





/*    public Mono<Artist> getArtist(final String mbid) {
        LOGGER.debug("Entered: getArtist");
        RestTemplate restTemplate = new RestTemplate();

        try {
            Artist artist =
                    restTemplate.getForObject(
                            TEST, Artist.class, mbid);

            return Mono.justOrEmpty(artist).switchIfEmpty(
                    Mono.error(new ArtistNotFoundException(mbid)));

        } catch (RestClientException e) {
            LOGGER.debug("Exiting: getArtist");
            return null;
        }
    }
    */
}
