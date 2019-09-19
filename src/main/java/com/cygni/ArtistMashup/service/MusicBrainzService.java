package com.cygni.ArtistMashup.service;

import com.cygni.ArtistMashup.model.json.ArtistJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class MusicBrainzService {
    private static Logger LOGGER = LoggerFactory.getLogger(MusicBrainzService.class);

    private static final String MBS_PATH =
            "http://musicbrainz.org/ws/2/artist/{id}?&fmt=json&inc=url-rels+release-groups";

    @GetMapping
    public ArtistJson getArtist(final String id) {
        LOGGER.debug("Entered: getArtist");
        RestTemplate restTemplate = new RestTemplate();

        try {
            ArtistJson artist =
                    restTemplate.getForObject(
                            MBS_PATH, ArtistJson.class, id);

            if(artist == null){
                LOGGER.debug("No artist found for given id: " + id);
            }

            LOGGER.debug("Exiting: getArtist");
            return artist;
        } catch (RestClientException e) {
            LOGGER.debug("Exception: " + e.getMessage());
            return null;
        }
    }
}
