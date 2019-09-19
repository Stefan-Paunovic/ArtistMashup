package com.cygni.ArtistMashup.service;

import com.jayway.jsonpath.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
@Cacheable("coverArtArchive")
public class CoverArtArchiveService {
    private static Logger LOGGER = LoggerFactory.getLogger(CoverArtArchiveService.class);

    private static final String CAA_PATH =
            "http://coverartarchive.org/release-group/{id}";

    @GetMapping
    public URL getCoverArt(final String id) {
        LOGGER.debug("Entered: getCoverArt");
        RestTemplate restTemplate = new RestTemplate();

        try {
            String coverArtJson =
                    restTemplate.getForObject(
                            CAA_PATH, String.class, id);

            if(coverArtJson == null){
                LOGGER.debug("No cover art found for given id: " + id);
            }

            //Look for when in images from == true and read whats in row named image
            List<String> fronts =
                    JsonPath.parse(coverArtJson)
                            .read("$..images[?(@.front == true)].image");

            try {
                return new URL(fronts.get(0));
            } catch (MalformedURLException e) {
                LOGGER.debug("Exception: " + e.getMessage());
                return null;
            }
        } catch (RestClientException e) {
            LOGGER.debug("Exception: " + e.getMessage());
            return null;
        }
    }
}